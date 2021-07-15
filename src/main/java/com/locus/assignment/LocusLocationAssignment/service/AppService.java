package com.locus.assignment.LocusLocationAssignment.service;

import com.google.maps.model.LatLng;
import com.locus.assignment.LocusLocationAssignment.exceptions.GenericException;
import com.locus.assignment.LocusLocationAssignment.model.Request;
import com.locus.assignment.LocusLocationAssignment.model.Response;
import com.locus.assignment.LocusLocationAssignment.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AppService {

    private static final int CONTINUOUS_DISTANCE_PATH = 50;
    private GeoApiService geoApiService;

    public AppService(GeoApiService geoApiService) {
        this.geoApiService = geoApiService;
    }

    public Response getPaths(Request request) throws GenericException {
        List<LatLng> directions = geoApiService.getDirections(request.getSource(), request.getDest());
        List<LatLng> equiDistantPoints = createEquiDistantPoints(directions);
        for (LatLng latLng : equiDistantPoints) {
            log.info("{}", latLng.toString());
        }
        return new Response(equiDistantPoints);
    }

    private List<LatLng> createEquiDistantPoints(List<LatLng> directions) {
        List<LatLng> equalDistPoints = new ArrayList<>();
        LatLng startPoint = directions.get(0);
        LatLng destPoint;
        equalDistPoints.add(startPoint);
        double destPointDistance, distanceCovered = 0;
        int nextIndex = 1;
        while (nextIndex < directions.size()) {
            destPoint = directions.get(nextIndex);
            destPointDistance = AppUtils.distanceBetweenTwoPointsInMetres(startPoint, destPoint);
            if (distanceCovered + destPointDistance < CONTINUOUS_DISTANCE_PATH) {
                startPoint = destPoint;
                distanceCovered += destPointDistance;
                nextIndex++;
            } else {
                startPoint = AppUtils.plotContinousDistancePoints(startPoint, destPoint,
                        CONTINUOUS_DISTANCE_PATH - distanceCovered);
                equalDistPoints.add(startPoint);
                distanceCovered = 0;
            }
        }
        return equalDistPoints;
    }
}

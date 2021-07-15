package com.locus.assignment.LocusLocationAssignment.utils;

import com.google.maps.model.LatLng;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class AppUtils {

    private static final double RADIUS_OF_EARTH = 6371000;

    public static double distanceBetweenTwoPointsInMetres(LatLng startPoint, LatLng destPoint) {
        double dLat = Math.toRadians(destPoint.lat - startPoint.lat);
        double dLon = Math.toRadians(destPoint.lng - startPoint.lng);

        double sinBetweenDistances = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(startPoint.lat))
                * Math.cos(Math.toRadians(destPoint.lat)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);

        double c = 2 * Math.asin(Math.sqrt(sinBetweenDistances));
        return RADIUS_OF_EARTH * c;

    }

    public static LatLng plotContinousDistancePoints(LatLng startPoint, LatLng destPoint, double distance) {
        LatLng interpolatedPoint = new LatLng();
        double totalDistance = distanceBetweenTwoPointsInMetres(startPoint, destPoint);
        double ratio = distance / totalDistance;
        interpolatedPoint.lat = startPoint.lat + ratio * (destPoint.lat - startPoint.lat);
        interpolatedPoint.lng = startPoint.lng + ratio * (destPoint.lng - startPoint.lng);
        return interpolatedPoint;
    }
}

package com.locus.assignment.LocusLocationAssignment.service;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.LatLng;
import com.locus.assignment.LocusLocationAssignment.exceptions.GenericException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class GeoApiService {

    private static final String API_KEY = "AIzaSyAEQvKUVouPDENLkQlCF6AAap1Ze-6zMos";
    private final GeoApiContext geoApiContext;

    public GeoApiService() {
        this.geoApiContext = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .connectTimeout(30, TimeUnit.SECONDS)
                .maxRetries(5)
                .build();
    }

    public List<LatLng> getDirections(LatLng source, LatLng dest) throws GenericException {
        try {
            DirectionsResult directionsResult = DirectionsApi.getDirections(geoApiContext, source.toString(), dest.toString()).await();
            //Getting List and converting to PolyLines
            return directionsResult.routes[0].overviewPolyline.decodePath();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            throw new GenericException("Google Not responding", e.getCause());
        }
    }

}

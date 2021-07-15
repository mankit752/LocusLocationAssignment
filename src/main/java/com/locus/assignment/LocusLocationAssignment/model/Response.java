package com.locus.assignment.LocusLocationAssignment.model;

import com.google.maps.model.LatLng;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Response {
    private List<LatLng> response;
}

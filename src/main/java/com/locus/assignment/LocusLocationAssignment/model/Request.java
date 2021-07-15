package com.locus.assignment.LocusLocationAssignment.model;

import com.google.maps.model.LatLng;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Request {
    private LatLng source;
    private LatLng dest;
}

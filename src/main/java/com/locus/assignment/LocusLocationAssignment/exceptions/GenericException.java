package com.locus.assignment.LocusLocationAssignment.exceptions;

public class GenericException extends Exception {
    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }
}

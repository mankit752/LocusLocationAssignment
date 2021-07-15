package com.locus.assignment.LocusLocationAssignment.controller;

import com.locus.assignment.LocusLocationAssignment.exceptions.GenericException;
import com.locus.assignment.LocusLocationAssignment.model.Request;
import com.locus.assignment.LocusLocationAssignment.model.Response;
import com.locus.assignment.LocusLocationAssignment.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AppController {

    private AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("/route")
    public ResponseEntity<Response> getRoute(@RequestBody Request request) {
        log.info("Input Request = {}", request);
        try {
            Response paths = appService.getPaths(request);
            return ResponseEntity.ok(paths);
        } catch (GenericException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}

package com.fisagrp.example.railway_track_management.controllers;

import com.fisagrp.example.railway_track_management.dto.requests.GraphCityRequest;
import com.fisagrp.example.railway_track_management.dto.responses.RailWayTrackManagementResponse;
import com.fisagrp.example.railway_track_management.services.RailWayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Gestión de Ferrocarril API", description = "API para la gestión de rutas y seguimiento de ferrocarriles. Proporciona endpoints para calcular distancias entre ciudades, contar rutas con ciertas características y realizar otras operaciones relacionadas con el ferrocarril")
@CrossOrigin(origins = "*")
@RestController("railway.v1.controller")
@RequestMapping("/")
public class RailWayController {

    @Autowired
    private RailWayService service;

    @PostMapping
    public ResponseEntity<RailWayTrackManagementResponse> manageRoads(@Valid @RequestBody GraphCityRequest request) {
        try {
            return new ResponseEntity<>(service.manageRoads(request.getGraph()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}

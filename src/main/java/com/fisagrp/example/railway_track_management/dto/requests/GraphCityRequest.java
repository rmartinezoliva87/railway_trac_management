package com.fisagrp.example.railway_track_management.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GraphCityRequest {

    @NotEmpty(message = "The field graph is required.")
    private String graph;
}

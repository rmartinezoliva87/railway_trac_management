package com.fisagrp.example.railway_track_management.services.impl;

import com.fisagrp.example.railway_track_management.dto.responses.RailWayTrackManagementResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RailWayServiceImplTest {

    private RailWayServiceImpl railWayServiceImpl;
    @BeforeEach
    void setUp() {
        railWayServiceImpl = new RailWayServiceImpl();
    }

    @Test
    public void testManageRoads() {
        RailWayServiceImpl railWayService = new RailWayServiceImpl();
        RailWayTrackManagementResponse response = railWayService.manageRoads("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");

        List<String> expectedAnswers = Arrays.asList(
                "Salida #1: 9",
                "Salida #2: 5",
                "Salida #3: 13",
                "Salida #4: 22",
                "Salida #5: NO HAY TAL RUTA",
                "Salida #6: 2",
                "Salida #7: 3",
                "Salida #8: 9",
                "Salida #9: 9",
                "Salida #10: 7"
        );

        assertEquals(expectedAnswers, response.getAnswers());
    }
}
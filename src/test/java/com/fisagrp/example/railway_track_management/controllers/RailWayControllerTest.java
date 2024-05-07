package com.fisagrp.example.railway_track_management.controllers;

import com.fisagrp.example.railway_track_management.dto.responses.RailWayTrackManagementResponse;
import com.fisagrp.example.railway_track_management.services.RailWayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(RailWayController.class)
class RailWayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RailWayService service;
    @Test
    void manageRoads() throws Exception {

       String graph = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";

        RailWayTrackManagementResponse response = new RailWayTrackManagementResponse();
        List<String> answers = new ArrayList<>();
        answers.add("Salida #1: 9");
        response.setAnswers(answers);

        when(service.manageRoads(graph)).thenReturn(response);

        when(service.manageRoads(graph)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/")
                        .contentType("application/json")
                        .content("{\n" +
                                "    \"graph\": \"" + graph + "\"\n" +
                                "}")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.answers").value(response.getAnswers()));
    }

    @Test
    void manageRoadsWithoutGraph() throws Exception {

        String graph = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";

        RailWayTrackManagementResponse response = new RailWayTrackManagementResponse();
        List<String> answers = new ArrayList<>();
                     answers.add("Salida #1: 9");

        response.setAnswers(answers);

        when(service.manageRoads(graph)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/")
                        .contentType("application/json")
                        .content("{\n" +
                                "    \"graph1\": \"" + graph + "\"\n" +
                                "}")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
package com.fisagrp.example.railway_track_management.services.impl;

import com.fisagrp.example.railway_track_management.dto.responses.RailWayTrackManagementResponse;
import com.fisagrp.example.railway_track_management.services.RailWayService;
import com.fisagrp.example.railway_track_management.helpers.GraphAlgorithmsHelper;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
@NoArgsConstructor
public class RailWayServiceImpl implements RailWayService {

    private Map<Character, Map<Character, Integer>> graph;

    @Override
    public RailWayTrackManagementResponse manageRoads(String graphCities) {

        //Inicializar el grafo
        init(graphCities);
        List<String> answers = new ArrayList<>();

        GraphAlgorithmsHelper graphAlgorithmsHelper = new GraphAlgorithmsHelper();

        answers.add("Salida #1: " + graphAlgorithmsHelper.calculateDistanceRoute(List.of('A', 'B', 'C'),graph));
        answers.add("Salida #2: " + graphAlgorithmsHelper.calculateDistanceRoute(List.of('A', 'D'),graph));
        answers.add("Salida #3: " + graphAlgorithmsHelper.calculateDistanceRoute(List.of('A', 'D', 'C'),graph));
        answers.add("Salida #4: " + graphAlgorithmsHelper.calculateDistanceRoute(List.of('A', 'E', 'B', 'C', 'D'),graph));
        answers.add("Salida #5: " + graphAlgorithmsHelper.calculateDistanceRoute(List.of('A', 'E', 'D'),graph));

        answers.add("Salida #6: " + graphAlgorithmsHelper.countRoutesWithMaxStops('C', 'C',0, 3, graph));
        answers.add("Salida #7: " + graphAlgorithmsHelper.countRoutesWithExactStops('A', 'C',0, 4, graph));
        answers.add("Salida #8: " + graphAlgorithmsHelper.shortestRouteDistance('A', 'C',0, graph));
        answers.add("Salida #9: " + graphAlgorithmsHelper.shortestRouteDistance('B', 'B', 0, graph));
        answers.add("Salida #10: " + graphAlgorithmsHelper.countRoutesWithMaxDistance('C', 'C',0 , 30, graph));

        RailWayTrackManagementResponse response = new RailWayTrackManagementResponse();
                                       response.setAnswers(answers);

        return response;
    }

   //Inicializar el grafo
   private void init(String graphCities) {
        graph = new HashMap<>();
        String[] routes = graphCities.split(",");

        for (String route : routes) {
            Character source = route.charAt(0);
            Character destination = route.charAt(1);
            Integer weight = Integer.parseInt(route.substring(2));
            addRoute(source, destination, weight);
        }
    }


   private void addRoute(Character source, Character destination, Integer weight) {
        if (!graph.containsKey(source)) {
            graph.put(source, new HashMap<>());
        }
        graph.get(source).put(destination, weight);
   }
}

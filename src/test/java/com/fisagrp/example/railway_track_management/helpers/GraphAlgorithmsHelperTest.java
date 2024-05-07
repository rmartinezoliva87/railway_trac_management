package com.fisagrp.example.railway_track_management.helpers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphAlgorithmsHelperTest {

    @Test
    void calculateDistanceRoute() {

        GraphAlgorithmsHelper helper = new GraphAlgorithmsHelper();

        Map<Character, Map<Character, Integer>> graph = new HashMap<>();
                                                graph.put('A', Map.of('B', 5));
                                                graph.put('B', Map.of('C', 4));

        List<Character> routeABC = List.of('A', 'B', 'C');
        assertEquals("9", helper.calculateDistanceRoute(routeABC, graph));

        List<Character> routeABD = List.of('A', 'B', 'D');
        assertEquals("NO HAY TAL RUTA", helper.calculateDistanceRoute(routeABD, graph));
    }

    @Test
    void countRoutesWithMaxStops() {
        GraphAlgorithmsHelper helper = new GraphAlgorithmsHelper();

        Map<Character, Map<Character, Integer>> graph = new HashMap<>();
            graph.put('A', Map.of('B', 1, 'C', 1));
            graph.put('B', Map.of('C', 1));

        assertEquals(2, helper.countRoutesWithMaxStops('A', 'C', 0, 2, graph));
    }

    @Test
    void countRoutesWithExactStops() {

        GraphAlgorithmsHelper helper = new GraphAlgorithmsHelper();

        Map<Character, Map<Character, Integer>> graph = new HashMap<>();
            graph.put('A', Map.of('B', 1, 'C', 1));
            graph.put('B', Map.of('C', 1));

        assertEquals(1, helper.countRoutesWithExactStops('A', 'C', 0, 2, graph));
    }

    @Test
    void shortestRouteDistance() {
        GraphAlgorithmsHelper helper = new GraphAlgorithmsHelper();

        Map<Character, Map<Character, Integer>> graph = new HashMap<>();
                                                graph.put('A', Map.of('B', 1, 'C', 1));
                                                graph.put('B', Map.of('C', 2));

        assertEquals(1, helper.shortestRouteDistance('A', 'C', 0, graph));
    }

    @Test
    void countRoutesWithMaxDistance() {
        GraphAlgorithmsHelper helper = new GraphAlgorithmsHelper();

        Map<Character, Map<Character, Integer>> graph = new HashMap<>();
                                                graph.put('A', Map.of('B', 5, 'C', 5));
                                                graph.put('B', Map.of('C', 5));

        assertEquals(2, helper.countRoutesWithMaxDistance('A', 'C', 0, 15, graph));
    }
}
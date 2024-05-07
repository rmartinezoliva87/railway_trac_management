package com.fisagrp.example.railway_track_management.helpers;

import lombok.NoArgsConstructor;

import java.util.*;

// Clase que contiene métodos para cálculos relacionados con grafos
@NoArgsConstructor
public class GraphAlgorithmsHelper {

    private int contRoutes;

    // Método para calcular la distancia de una ruta dada
    public String calculateDistanceRoute(List<Character> route, Map<Character, Map<Character, Integer>> graph) {
        int distance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            char current = route.get(i);
            char next = route.get(i + 1);
            if (graph.containsKey(current) && graph.get(current).containsKey(next)) {
                distance += graph.get(current).get(next);
            } else {
                return "NO HAY TAL RUTA";
            }
        }
        return distance + "";
    }

    // Método para contar las rutas con un número máximo de paradas
    public int countRoutesWithMaxStops(char current, char end, int stops, int maxStops, Map<Character, Map<Character, Integer>> graph) {
        if (stops > maxStops) return 0;
        if (current == end && stops > 0) return 1;
        int count = 0;
        if (graph.get(current) != null) {
            for (Map.Entry<Character, Integer> entry : graph.get(current).entrySet()) {
                count += countRoutesWithMaxStops(entry.getKey(), end, stops + 1, maxStops, graph);
            }
        }
        return count;
    }

    // Método para contar las rutas con un número exacto de paradas
    public int countRoutesWithExactStops(char current, char end, int stops, int exactStops, Map<Character, Map<Character, Integer>> graph) {
        if (stops == exactStops && current == end) return 1;
        if (stops > exactStops) return 0;
        int count = 0;
        if (graph.get(current) != null) {
        for (Map.Entry<Character, Integer> entry : graph.get(current).entrySet()) {
            count += countRoutesWithExactStops(entry.getKey(), end, stops + 1, exactStops, graph);
        }}
        return count;
    }

    // Método para encontrar la distancia de la ruta más corta entre dos nodos
    public int shortestRouteDistance(char start, char end, int pos, Map<Character, Map<Character, Integer>> graph) {
        Map<Character, Integer> distances = new HashMap<>();
        for (char node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        //Usamos un PriorityQueue para mantener un seguimiento de los nodos que aún no se han visitado, ordenados por la distancia más corta conocida.
        PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (current == end && pos!=0) {
                return distances.get(end);
            }
            if (!graph.containsKey(current)) {
                continue;
            }
            pos++;

            if (graph.get(current) != null) {
                for (Map.Entry<Character, Integer> entry : graph.get(current).entrySet()) {
                    int distanceThroughCurrent = distances.get(current) + entry.getValue();
                    if (entry.getKey() == end && pos != 0) {
                        return distanceThroughCurrent;
                    }
                    if (distanceThroughCurrent < distances.get(entry.getKey())) {
                        distances.put(entry.getKey(), distanceThroughCurrent);
                        queue.add(entry.getKey());
                    }
                }
            }
        }
        return -1; // No such route
    }

    // Método para contar las rutas con una distancia máxima dada
    public int countRoutesWithMaxDistance(char current, char end, int currentDistance, int maxDistance, Map<Character, Map<Character, Integer>> graph) {
        this.contRoutes = 0;
        countRoutesWithMaxDistanceAux(current, end, currentDistance, maxDistance, graph);
        return this.contRoutes;
    }

    // Método auxiliar recursivo para contar las rutas con una distancia máxima dada
    private void countRoutesWithMaxDistanceAux(char current, char end, int currentDistance, int maxDistance,Map<Character, Map<Character, Integer>> graph) {
        if (current == end && currentDistance>0 && currentDistance < maxDistance) {
            this.contRoutes++;
        }
        if (currentDistance >= maxDistance) {
            return;
        }

        if (graph.get(current) != null) {
            for (Map.Entry<Character, Integer> entry : graph.get(current).entrySet()) {
                countRoutesWithMaxDistanceAux(entry.getKey(), end, currentDistance + entry.getValue(), maxDistance, graph);
            }
        }
    }
}

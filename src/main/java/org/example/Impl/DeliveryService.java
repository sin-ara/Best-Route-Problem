package org.example.Impl;

import org.example.Model.*;

import java.util.ArrayList;
import java.util.List;

public class DeliveryService {
    public void findOptimalRoute(DeliveryExecutive de, List<Customer> customers, List<Restaurant> restaurants, List<Order> orders) {
        List<Coordinates> points = new ArrayList<>();
        points.add(new Coordinates(de.getCoordinates().getX(), de.getCoordinates().getY()));
        for (int i = 0; i < customers.size(); i++) {
            points.add(new Coordinates(restaurants.get(i).getCoordinates().getX(), restaurants.get(i).getCoordinates().getY()));
            points.add(new Coordinates(customers.get(i).getCoordinates().getX(), customers.get(i).getCoordinates().getY()));
        }

        // Calculate distances between all points
        double[][] distanceMatrix = new double[points.size()][points.size()];
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                distanceMatrix[i][j] = calculateDistance(points.get(i), points.get(j));
            }
        }

        // Create a list to keep track of visited nodes
        boolean[] visited = new boolean[points.size()];
        visited[0] = true; // Start at the first Coordinates
        List<Integer> path = new ArrayList<>();
        path.add(0);

        // Find the optimal path using a recursive approach
        findOptimalPath(0, visited, distanceMatrix, path);

        // Calculate the total time taken
        double totalTime = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            int from = path.get(i);
            int to = path.get(i + 1);
            if (to % 2 == 1) { // If the destination is a restaurant
                Order order = orders.get(to / 2);
                totalTime += order.getRestaurant().getPreparationTime(); // Add preparation time
            }
            totalTime += distanceMatrix[from][to] / 20 * 60 ; // Add travel time in minutes
        }

        System.out.println("Total Time: " + totalTime);

    }

    public double calculateDistance(Coordinates location1, Coordinates location2) {
        final double R = 6371; // Radius of the Earth in kilometers
        double lat1 = Math.toRadians(location1.getX());
        double lon1 = Math.toRadians(location1.getY());
        double lat2 = Math.toRadians(location2.getX());
        double lon2 = Math.toRadians(location2.getY());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c; // Distance in kilometers
    }

    private static void findOptimalPath(int current, boolean[] visited, double[][] distanceMatrix, List<Integer> path) {
        if (path.size() == visited.length) { // All points visited
            return;
        }

        double minDistance = Double.MAX_VALUE;
        int next = -1;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                double distance = distanceMatrix[current][i];
                if (distance < minDistance) {
                    minDistance = distance;
                    next = i;
                }
            }
        }

        visited[next] = true;
        path.add(next);
        findOptimalPath(next, visited, distanceMatrix, path);
    }
}

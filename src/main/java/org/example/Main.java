package org.example;

import org.example.Impl.DeliveryService;
import org.example.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) {
        DeliveryExecutive de = new DeliveryExecutive(new Coordinates(12.9345, 77.6450));
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("c1",new Coordinates(12.9546, 77.6700)));
        customers.add(new Customer("c2",new Coordinates(12.9263, 77.6522)));

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("r1", 10, new Coordinates(12.9334, 77.6295)));
        restaurants.add(new Restaurant("r2", 15, new Coordinates(12.9467, 77.6314)));

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("a123", customers.get(0), restaurants.get(0)));
        orders.add(new Order("a234", customers.get(1), restaurants.get(1)));

        DeliveryService deliveryService = new DeliveryService();
        deliveryService.findOptimalRoute(de, customers, restaurants, orders);
    }
}
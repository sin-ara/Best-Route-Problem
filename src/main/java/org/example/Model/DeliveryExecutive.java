package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DeliveryExecutive {
    Coordinates coordinates;

    public List<Order> getAssignedOrders() {
        return assignedOrders;
    }

    public void setAssignedOrders(List<Order> assignedOrders) {
        this.assignedOrders = assignedOrders;
    }

    List<Order> assignedOrders;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void addOrder(Order order) {
        assignedOrders.add(order);
    }

    public DeliveryExecutive(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.assignedOrders = new ArrayList<>();
    }
}

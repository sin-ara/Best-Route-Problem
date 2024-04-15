package org.example.Model;

import org.example.Main;

public class Customer {
    public String customerId;
//    public Restaurant restaurant;
    Coordinates coordinates;



//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    //    public Customer(int customerId, Restaurant restaurant, Coordinates coordinates){
//        this.customerId = customerId;
//        this.restaurant = restaurant;
//        this.coordinates = coordinates;
//    }


    public Customer(String customerId, Coordinates coordinates) {
        this.customerId = customerId;
        this.coordinates = coordinates;
    }
}
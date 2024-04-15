package org.example.Model;

public class Restaurant {
    String restaurantId;
    int preparationTime;
    Coordinates coordinates;



    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Restaurant(String restaurantId, int preparationTime, Coordinates coordinates) {
        this.restaurantId = restaurantId;
        this.preparationTime = preparationTime;
        this.coordinates = coordinates;
    }

    //    public Restaurant(int restaurantId, int preparationTime, Coordinates coordinates) {
//        this.coordinates = coordinates;
//        this.restaurantId = restaurantId;
//        this.preparationTime = preparationTime;
//    }


}
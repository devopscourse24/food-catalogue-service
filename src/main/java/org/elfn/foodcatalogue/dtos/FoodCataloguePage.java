package org.elfn.foodcatalogue.dtos;

import org.elfn.foodcatalogue.entities.FoodItem;

import java.util.List;

public class FoodCataloguePage {

    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;

    public List<FoodItem> getFoodItemsList() {
        return foodItemsList;
    }

    public void setFoodItemsList(List<FoodItem> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

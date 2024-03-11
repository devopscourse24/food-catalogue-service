package org.elfn.foodcatalogue.services;

import org.elfn.foodcatalogue.dtos.FoodCataloguePage;
import org.elfn.foodcatalogue.dtos.FoodItemDTO;
import org.elfn.foodcatalogue.dtos.Restaurant;
import org.elfn.foodcatalogue.entities.FoodItem;
import org.elfn.foodcatalogue.mappers.FoodItemMapper;
import org.elfn.foodcatalogue.repositories.FoodItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCatalogueService {

    final FoodItemRepository foodItemRepository;

    final RestTemplate restTemplate;

    public FoodCatalogueService(FoodItemRepository foodItemRepository, RestTemplate restTemplate) {
        this.foodItemRepository = foodItemRepository;
        this.restTemplate = restTemplate;
    }

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem savedFoodItem = foodItemRepository.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(savedFoodItem);
    }


    public ResponseEntity<FoodItemDTO> fetchFoodItemDetailsById(Integer id) {
        Optional<FoodItem> fetchedItem = foodItemRepository.findById(id);
        if (fetchedItem.isPresent()) {
            return new ResponseEntity<>(FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(fetchedItem.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }


    // Déclaration d'une méthode privée qui retourne une instance de la classe Restaurant.
    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        // Appel au microservice Restaurant en utilisant RestTemplate pour récupérer les détails d'un restaurant spécifique.
        // L'URL utilise le nom du service (RESTAURANT-SERVICE) au lieu d'une adresse IP ou d'un nom de domaine,
        // cela indique que l'équilibrage de charge et la résolution de nom sont gérés par un service de découverte comme Eureka.
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/" + restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepository.findAllByRestaurantId(restaurantId);
    }

}

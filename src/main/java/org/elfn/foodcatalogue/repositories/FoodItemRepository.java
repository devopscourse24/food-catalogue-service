package org.elfn.foodcatalogue.repositories;

import org.elfn.foodcatalogue.entities.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {

    List<FoodItem> findAllByRestaurantId(Integer id);

}

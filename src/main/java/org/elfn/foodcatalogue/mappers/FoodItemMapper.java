package org.elfn.foodcatalogue.mappers;

import org.elfn.foodcatalogue.dtos.FoodItemDTO;
import org.elfn.foodcatalogue.entities.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    @Mapping(source = "restaurantId", target = "restaurantId")
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);

}

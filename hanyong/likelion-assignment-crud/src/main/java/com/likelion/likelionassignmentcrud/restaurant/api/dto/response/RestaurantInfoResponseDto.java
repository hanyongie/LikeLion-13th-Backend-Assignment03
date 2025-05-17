package com.likelion.likelionassignmentcrud.restaurant.api.dto.response;

import com.likelion.likelionassignmentcrud.restaurant.domain.Part;
import com.likelion.likelionassignmentcrud.restaurant.domain.Restaurant;
import lombok.Builder;

@Builder
public record RestaurantInfoResponseDto(
        String name,
        String number,
        Part part
) {
    public static RestaurantInfoResponseDto from(Restaurant restaurant) {
        return RestaurantInfoResponseDto.builder()
                .name(restaurant.getName())
                .number(restaurant.getNumber())
                .part(restaurant.getPart())
                .build();
    }
}

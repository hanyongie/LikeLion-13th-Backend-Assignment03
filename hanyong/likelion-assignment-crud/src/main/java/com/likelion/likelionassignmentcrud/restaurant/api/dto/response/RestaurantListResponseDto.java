package com.likelion.likelionassignmentcrud.restaurant.api.dto.response;

import com.likelion.likelionassignmentcrud.restaurant.domain.Restaurant;
import lombok.Builder;

import java.util.List;

@Builder
public record RestaurantListResponseDto(
        List<RestaurantInfoResponseDto> restaurants
) {
    public static RestaurantListResponseDto from(List<RestaurantInfoResponseDto> restaurant) {
        return RestaurantListResponseDto.builder()
                .restaurants(restaurant)
                .build();
    }
}

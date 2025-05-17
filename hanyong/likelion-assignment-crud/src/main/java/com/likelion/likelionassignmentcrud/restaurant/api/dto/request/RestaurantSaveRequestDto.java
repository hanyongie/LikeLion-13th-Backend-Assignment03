package com.likelion.likelionassignmentcrud.restaurant.api.dto.request;

import com.likelion.likelionassignmentcrud.restaurant.domain.Part;

public record RestaurantSaveRequestDto(
        String name,
        String number,
        Part part
) {
}

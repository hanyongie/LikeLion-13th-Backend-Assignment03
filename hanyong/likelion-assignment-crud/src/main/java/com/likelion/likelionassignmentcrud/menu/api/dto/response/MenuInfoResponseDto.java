package com.likelion.likelionassignmentcrud.menu.api.dto.response;

import com.likelion.likelionassignmentcrud.menu.domain.Menu;
import lombok.Builder;

@Builder
public record MenuInfoResponseDto(
        String mname,
        int price,
        String name
) {
    public static MenuInfoResponseDto from(Menu menu) {
        return MenuInfoResponseDto.builder()
                .mname(menu.getMname())
                .price(menu.getPrice())
                .name(menu.getRestaurant().getName())
                .build();
    }
}

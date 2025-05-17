package com.likelion.likelionassignmentcrud.menu.api.dto.request;

public record MenuSaveRequestDto(
        Long menuId,
        String mname,
        int price
) {
}

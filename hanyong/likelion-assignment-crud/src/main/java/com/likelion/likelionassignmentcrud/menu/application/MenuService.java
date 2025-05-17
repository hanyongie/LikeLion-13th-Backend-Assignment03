package com.likelion.likelionassignmentcrud.menu.application;

import com.likelion.likelionassignmentcrud.menu.api.dto.request.MenuSaveRequestDto;
import com.likelion.likelionassignmentcrud.menu.api.dto.response.MenuInfoResponseDto;
import com.likelion.likelionassignmentcrud.menu.api.dto.response.MenuListResponseDto;
import com.likelion.likelionassignmentcrud.menu.domain.Menu;
import com.likelion.likelionassignmentcrud.menu.domain.repository.MenuRepository;
import com.likelion.likelionassignmentcrud.restaurant.domain.Restaurant;
import com.likelion.likelionassignmentcrud.restaurant.domain.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional (readOnly = true)
public class MenuService {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    //게시물 저장
    @Transactional
    public void menuSave(MenuSaveRequestDto menuSaveRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(menuSaveRequestDto.menuId()).orElseThrow(IllegalArgumentException::new);
        Menu menu = Menu.builder()
                .mname(menuSaveRequestDto.mname())
                .price(menuSaveRequestDto.price())
                .restaurant(restaurant)
                .build();
        menuRepository.save(menu);
    }
    //특정 작성자가 작성한 게시글 목록을 조회
    public MenuListResponseDto menuFindRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(IllegalArgumentException::new);

        List<Menu> menus = menuRepository.findByRestaurant(restaurant);
        List<MenuInfoResponseDto> menuInfoResponseDtos = menus.stream()
                .map(MenuInfoResponseDto::from)
                .toList();
        return MenuListResponseDto.from(menuInfoResponseDtos);
    }
}

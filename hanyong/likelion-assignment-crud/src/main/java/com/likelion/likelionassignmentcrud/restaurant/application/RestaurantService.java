package com.likelion.likelionassignmentcrud.restaurant.application;

import com.likelion.likelionassignmentcrud.restaurant.api.dto.request.RestaurantSaveRequestDto;
import com.likelion.likelionassignmentcrud.restaurant.api.dto.response.RestaurantInfoResponseDto;
import com.likelion.likelionassignmentcrud.restaurant.api.dto.response.RestaurantListResponseDto;
import com.likelion.likelionassignmentcrud.restaurant.domain.Restaurant;
import com.likelion.likelionassignmentcrud.restaurant.domain.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    //식당 정보 저장
    @Transactional
    public void restaurantSave(RestaurantSaveRequestDto restaurantSaveRequestDto) {
        Restaurant restaurant = Restaurant.builder()
                .name(restaurantSaveRequestDto.name())
                .number(restaurantSaveRequestDto.number())
                .part(restaurantSaveRequestDto.part())
                .build();
        restaurantRepository.save(restaurant);
    }

    //식당 모두 조회
    public RestaurantListResponseDto restaurantfindAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantInfoResponseDto> restaurantInfoResponseDtoList = restaurants.stream()
                .map(RestaurantInfoResponseDto::from)
                .toList();
        return RestaurantListResponseDto.from(restaurantInfoResponseDtoList);
    }
    // 단일 식당 조회
    public RestaurantInfoResponseDto restaurantFindOne(Long restaurantId) {
        Restaurant restaurant = restaurantRepository
                .findById(restaurantId)
                .orElseThrow(IllegalArgumentException::new);
        return RestaurantInfoResponseDto.from(restaurant);
    }
}

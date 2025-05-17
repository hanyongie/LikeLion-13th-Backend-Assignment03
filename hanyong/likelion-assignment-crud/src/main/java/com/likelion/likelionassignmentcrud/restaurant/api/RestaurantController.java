package com.likelion.likelionassignmentcrud.restaurant.api;

import com.likelion.likelionassignmentcrud.restaurant.api.dto.request.RestaurantSaveRequestDto;
import com.likelion.likelionassignmentcrud.restaurant.api.dto.response.RestaurantInfoResponseDto;
import com.likelion.likelionassignmentcrud.restaurant.api.dto.response.RestaurantListResponseDto;
import com.likelion.likelionassignmentcrud.restaurant.application.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    //사용자 저장
    @PostMapping("/save")
    public ResponseEntity<String> restaurantSave(@RequestBody RestaurantSaveRequestDto restaurantSaveRequestDto){
        restaurantService.restaurantSave(restaurantSaveRequestDto);
        return new ResponseEntity<>("사용자 저장!", HttpStatus.CREATED);
    }
    //사용자 전체 조회
    @GetMapping("/all")
    public ResponseEntity<RestaurantListResponseDto>restaurantFindAll(){
        RestaurantListResponseDto restaurantListResponseDto = restaurantService.restaurantfindAll();
        return new ResponseEntity<>(restaurantListResponseDto, HttpStatus.OK);
    }

    //회원 id를 통해 특정 사용자 조회
    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantInfoResponseDto> restaurantFindOne(@PathVariable("restaurantId") Long restaurantId){
        RestaurantInfoResponseDto restaurantInfoResponseDto = restaurantService.restaurantFindOne(restaurantId);
        return new ResponseEntity<>(restaurantInfoResponseDto, HttpStatus.OK);
    }
}

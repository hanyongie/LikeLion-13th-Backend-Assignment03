package com.likelion.likelionassignmentcrud.menu.api;

import com.likelion.likelionassignmentcrud.menu.api.dto.request.MenuSaveRequestDto;
import com.likelion.likelionassignmentcrud.menu.api.dto.response.MenuListResponseDto;
import com.likelion.likelionassignmentcrud.menu.application.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    //메뉴 저장
    @PostMapping("/save")
    public ResponseEntity<String> menuSave(@RequestBody MenuSaveRequestDto menuSaveRequestDto){
        menuService.menuSave(menuSaveRequestDto);
        return new ResponseEntity<>("메뉴 저장!",HttpStatus.CREATED);
    }

    //식당 id를 기준으르ㅗ 해당 식당의 메뉴 목록 조회
    @GetMapping("/{restaurantId}")
    public ResponseEntity<MenuListResponseDto> MenuFindAll(@PathVariable("restaurantId") Long restaurantId){
        MenuListResponseDto menuListResponseDto = menuService.menuFindRestaurant(restaurantId);
        return new ResponseEntity<>(menuListResponseDto, HttpStatus.OK);
    }
}

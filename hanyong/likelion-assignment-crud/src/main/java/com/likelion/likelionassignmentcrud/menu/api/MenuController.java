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

    //게시물 저장
    @PostMapping("/save")
    public ResponseEntity<String> menuSave(@RequestBody MenuSaveRequestDto menuSaveRequestDto){
        menuService.menuSave(menuSaveRequestDto);
        return new ResponseEntity<>("게시물 저장!",HttpStatus.CREATED);
    }

    //사용자 id를 기준으르ㅗ 해당 사용자가 작성한 게시글 목록 조회
    @GetMapping("/{restaurantId}")
    public ResponseEntity<MenuListResponseDto> MenuFindAll(@PathVariable("restaurantId") Long restaurantId){
        MenuListResponseDto menuListResponseDto = menuService.menuFindRestaurant(restaurantId);
        return new ResponseEntity<>(menuListResponseDto, HttpStatus.OK);
    }
}

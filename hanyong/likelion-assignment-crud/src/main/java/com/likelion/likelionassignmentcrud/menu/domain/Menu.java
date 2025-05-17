package com.likelion.likelionassignmentcrud.menu.domain;

import com.likelion.likelionassignmentcrud.restaurant.domain.Restaurant;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    private String mname;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Builder
    private Menu(String mname, int price, Restaurant restaurant) {
        this.mname = mname;
        this.price = price;
        this.restaurant = restaurant;
    }
}

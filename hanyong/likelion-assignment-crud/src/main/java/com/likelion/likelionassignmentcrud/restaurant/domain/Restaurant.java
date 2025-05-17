package com.likelion.likelionassignmentcrud.restaurant.domain;

import com.likelion.likelionassignmentcrud.menu.domain.Menu;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    private String name;

    private String number;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Part part;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menu = new ArrayList<>();

    @Builder
    private Restaurant(String name, String number, Part part) {
        this.name = name;
        this.number = number;
        this.part = part;
    }
}

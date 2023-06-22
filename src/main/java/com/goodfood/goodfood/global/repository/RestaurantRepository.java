package com.goodfood.goodfood.global.repository;

import com.goodfood.goodfood.global.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
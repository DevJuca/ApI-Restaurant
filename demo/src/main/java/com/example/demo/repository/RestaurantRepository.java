package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
}

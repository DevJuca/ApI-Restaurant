package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.DrinksItem;

public interface DrinksRepository extends JpaRepository<DrinksItem, Long> {
    
}

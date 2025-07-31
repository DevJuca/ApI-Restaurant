package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PratoItem;

public interface PratoItemRepository extends JpaRepository<PratoItem, Long> {
    
}

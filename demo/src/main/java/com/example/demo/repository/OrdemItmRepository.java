package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.OrdemItem;
import com.example.demo.models.PK.OrdemItemPk;

public interface OrdemItmRepository extends JpaRepository<OrdemItem, OrdemItemPk>{
    
}

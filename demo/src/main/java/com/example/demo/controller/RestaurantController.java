package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.models.Restaurant;
import com.example.demo.services.RestaurantService;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> fiindAll(){
        List<Restaurant> restau = restaurantService.findAll();
        return ResponseEntity.ok().body(restau);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable Long id){
        Restaurant restau = restaurantService.findById(id);
        return ResponseEntity.ok().body(restau);
    }

    @PostMapping
    public ResponseEntity<Restaurant> insert(@RequestBody Restaurant restau){
        restau = restaurantService.insert(restau);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(restau.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        restaurantService.delete(id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable long id, @RequestBody Restaurant restau){
        restau = restaurantService.update(id, restau);
        return ResponseEntity.ok().body(restau);
    }
}


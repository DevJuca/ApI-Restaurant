package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.models.DrinksItem;
import com.example.demo.services.DrinksServices;

@RestController
@RequestMapping(value = "/drinks")
public class DrinkController {
    @Autowired
    private DrinksServices drinksServices;

    @GetMapping
    public ResponseEntity<List<DrinksItem>> findAll(){
        List<DrinksItem> drinks = drinksServices.findAll();
        return ResponseEntity.ok().body(drinks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DrinksItem> findByID(@PathVariable Long id){
        DrinksItem drinks = drinksServices.findById(id);
        return ResponseEntity.ok().body(drinks);
    }

    @PostMapping
    public ResponseEntity<DrinksItem> update(@RequestBody DrinksItem drinks){
        drinks = drinksServices.insert(drinks);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(drinks.getId()).toUri();

        return ResponseEntity.created(uri).body(drinks);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        drinksServices.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DrinksItem> update(@PathVariable Long id, @RequestBody DrinksItem drinks){
        drinks = drinksServices.update(id, drinks);
        return ResponseEntity.ok().body(drinks);
    }
}

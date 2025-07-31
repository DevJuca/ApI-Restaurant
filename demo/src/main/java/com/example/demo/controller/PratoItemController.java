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

import com.example.demo.models.PratoItem;
import com.example.demo.services.PratoItemServices;

@RestController
@RequestMapping(value = "/pratos")
public class PratoItemController {

    @Autowired
    private PratoItemServices pratoItemServices;

    @GetMapping
    public ResponseEntity<List<PratoItem>> findAll(){
        List<PratoItem> pratoItm = pratoItemServices.findAll();
        return ResponseEntity.ok().body(pratoItm);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PratoItem> findById(@PathVariable Long id){
        PratoItem pratoItm = pratoItemServices.findByID(id);
        return ResponseEntity.ok().body(pratoItm);
    }

    @PostMapping
    public ResponseEntity<PratoItem> update(@RequestBody PratoItem pratoItm){
        pratoItm = pratoItemServices.insert(pratoItm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pratoItm.getId()).toUri();

        return ResponseEntity.created(uri).body(pratoItm);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pratoItemServices.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PratoItem> update(@PathVariable Long id, @RequestBody PratoItem pratoItm){
        pratoItm = pratoItemServices.update(id, pratoItm);
        return ResponseEntity.ok().body(pratoItm);
    }
}

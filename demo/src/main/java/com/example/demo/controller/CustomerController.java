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

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerServices;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    
    @Autowired
    private CustomerServices customerServices;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> cust = customerServices.findAll();
        return ResponseEntity.ok().body(cust);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findByID(@PathVariable Long id){
        Customer cust = customerServices.findById(id);
        return ResponseEntity.ok().body(cust);
    }

    @PostMapping
    public ResponseEntity<Customer> update(@RequestBody Customer cust){
        cust = customerServices.insert(cust);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cust.getId()).toUri();

        return ResponseEntity.created(uri).body(cust);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        customerServices.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer cust){
        cust = customerServices.update(id, cust);
        return ResponseEntity.ok().body(cust);
    }
}

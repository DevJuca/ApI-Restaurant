package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.models.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.services.ResourcesException.DataBaseException;
import com.example.demo.services.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    // Lista todos os restaurantes.
    public List<Restaurant> findAll(){
        return restaurantRepository.findAll();
    }

    // Lista um restaurante específico pelo id.
    public Restaurant findById(Long id){
        Optional<Restaurant> restau = restaurantRepository.findById(id);
        return restau.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    // Cria um restaurante.
    public Restaurant insert(Restaurant restau){
        return restaurantRepository.save(restau);
    }

    // Deleta um restaurante específico pelo id.
    public void delete(Long id){
        try {
            restaurantRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    // Atualiza dados de um restaurante específico pelo id.
    public Restaurant update(Long id, Restaurant restau){
        try{
            Restaurant entity = restaurantRepository.getReferenceById(id);
            updateDataRestaurant(entity, restau);
            return restaurantRepository.save(entity);
        }catch(EntityNotFoundException e){
            throw new ResourcesNotFoundException(id);
        }
    }

    private void updateDataRestaurant(Restaurant entity, Restaurant restau){
        entity.setName(restau.getName());
        entity.setLocation(restau.getLocation());
    }
}

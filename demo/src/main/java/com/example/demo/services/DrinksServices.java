package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.models.DrinksItem;
import com.example.demo.repository.DrinksRepository;
import com.example.demo.services.ResourcesException.DataBaseException;
import com.example.demo.services.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DrinksServices {
    @Autowired
    private DrinksRepository drinksRepository;

    // Lista todos os bebidas.
    public List<DrinksItem> findAll() {
        return drinksRepository.findAll();
    }

    // Lista um bebida específico pelo id.
    public DrinksItem findById(Long id) {
        Optional<DrinksItem> drink = drinksRepository.findById(id);
        return drink.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    // Cria um bebida.
    public DrinksItem insert(DrinksItem drink) {
        return drinksRepository.save(drink);
    }

    // Deleta um bebida específico pelo id.
    public void delete(Long id) {
        try {
            drinksRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    // Atualiza dados de um bebida específico pelo id.
    public DrinksItem update(Long id, DrinksItem drink) {
        try {
            DrinksItem entity = drinksRepository.getReferenceById(id);
            updateDataCostumer(entity, drink);
            return drinksRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    private void updateDataCostumer(DrinksItem entity, DrinksItem drink) {
        entity.setName(drink.getName());
        entity.setPrice(drink.getPrice());
        entity.setDescription(drink.getDescription());
        entity.setDrinksEnum(drink.getDrinksEnum());
    }
}

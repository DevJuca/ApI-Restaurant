package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.models.PratoItem;
import com.example.demo.repository.PratoItemRepository;
import com.example.demo.services.ResourcesException.DataBaseException;
import com.example.demo.services.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PratoItemServices {
    @Autowired
    private PratoItemRepository menuItemRepository;


    public List<PratoItem> findAll(){
        return menuItemRepository.findAll();
    }


    public PratoItem findByID(Long id){
        Optional<PratoItem> menuItm = menuItemRepository.findById(id);
        return menuItm.orElseThrow(() -> new ResourcesNotFoundException(id));
    }


    public PratoItem insert(PratoItem menuItm){
        return menuItemRepository.save(menuItm);
    }


    // Deleta um pedido específico pelo id.
    public void delete(Long id){
        try {
            menuItemRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    // Atualiza dados de um pedido específico pelo id.
    public PratoItem update(Long id, PratoItem menuItm){
        try {
            PratoItem entity = menuItemRepository.getReferenceById(id);
            updateDataMenuItem(entity, menuItm);
            return menuItemRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    private void updateDataMenuItem(PratoItem entity, PratoItem menuItm){
        entity.setName(menuItm.getName());
        entity.setPrice(menuItm.getPrice());
        entity.setDescription(menuItm.getDescription());
    }
}

package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.models.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.services.ResourcesException.DataBaseException;
import com.example.demo.services.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    // Lista todos os pedidos.
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    // Lista um pedido específico pelo id.
    public Order findById(Long id){
        Optional<Order> ord = orderRepository.findById(id);
        return ord.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    // Cria um pedido.
    public Order insert(Order ord){
        return orderRepository.save(ord);
    }

    // Deleta um pedido específico pelo id.
    public void delete(Long id){
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    // Atualiza dados de um pedido específico pelo id.
    public Order update(Long id, Order ord){
        try {
            Order entity = orderRepository.getReferenceById(id);
            updateDataOrder(entity, ord);
            return orderRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    private void updateDataOrder(Order entity, Order ord){
        entity.setTipo_pedido(ord.getTipo_pedido());
        entity.setStatus_pedido(ord.getStatus_pedido());
    }
    
}

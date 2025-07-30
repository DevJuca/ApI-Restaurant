package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.ResourcesException.DataBaseException;
import com.example.demo.services.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;

    // Lista todos os clientes.
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // Lista um cliente específico pelo id.
    public Customer findById(Long id) {
        Optional<Customer> cust = customerRepository.findById(id);
        return cust.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    // Cria um cliente.
    public Customer insert(Customer cust) {
        return customerRepository.save(cust);
    }

    // Deleta um cliente específico pelo id.
    public void delete(Long id) {
        try {
            customerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    // Atualiza dados de um cliente específico pelo id.
    public Customer update(Long id, Customer cust) {
        try {
            Customer entity = customerRepository.getReferenceById(id);
            updateDataCostumer(entity, cust);
            return customerRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    private void updateDataCostumer(Customer entity, Customer cust) {
        entity.setName(cust.getName());
        entity.setEmail(cust.getEmail());
    }
}

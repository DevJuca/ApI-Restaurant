package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.Enums.StatusPedidoEnum;
import com.example.Enums.TipoPedidoEnum;
import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import com.example.demo.models.Restaurant;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.RestaurantRepository;

@Configuration
@Profile("test")
public class Test_config implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public void run(String... args) throws Exception {
        // Customers
        Customer cust1 = new Customer(null, "Aiden Pierce", "aidenpierce@gmail.com");
        Customer cust2 = new Customer(null, "Nicole Pierce", "nicolepierce@gmail.com");
        customerRepository.saveAll(Arrays.asList(cust1,cust2));


        // Orders
        Order ord1 = new Order(0, Instant.parse("2025-07-29T13:18:45Z"), TipoPedidoEnum.Presencial, StatusPedidoEnum.EmPreparo);
        Order ord2 = new Order(0, Instant.parse("2025-07-29T15:25:30Z"), TipoPedidoEnum.Presencial, StatusPedidoEnum.Pronto);
        orderRepository.saveAll(Arrays.asList(ord1,ord2));

        
        // Restaurants
        Restaurant restau1 = new Restaurant(0, "Alto Nero - Unidade Av.Paulista", "Av. Paulista, 2295 – Bela Vista, São Paulo – SP");
        Restaurant restau2 = new Restaurant(0, "Alto Nero - Unidade Piinheiros", "Rua dos Pinheiros, 661 – Pinheiros, São Paulo – SP");
        restaurantRepository.saveAll(Arrays.asList(restau1,restau2));

    }
    
}

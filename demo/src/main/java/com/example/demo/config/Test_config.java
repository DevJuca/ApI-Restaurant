package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.Enums.DrinksEnum;
import com.example.Enums.MenuItemEnum;
import com.example.Enums.StatusPedidoEnum;
import com.example.Enums.TipoPedidoEnum;
import com.example.demo.models.Customer;
import com.example.demo.models.DrinksItem;
import com.example.demo.models.OrdemItem;
import com.example.demo.models.PratoItem;
import com.example.demo.models.Order;
import com.example.demo.models.Payment;
import com.example.demo.models.Restaurant;
import com.example.demo.repository.*;

@Configuration
@Profile("test")
public class Test_config implements CommandLineRunner {



    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private PratoItemRepository pratoItemRepository;

    @Autowired
    private DrinksRepository drinksRepository;

    @Autowired
    private OrdemItmRepository ordemItmRepository;


    @Override
    public void run(String... args) throws Exception {
        // Customers
        Customer cust1 = new Customer(null, "Aiden Pierce", "aidenpierce@gmail.com");
        Customer cust2 = new Customer(null, "Nicole Pierce", "nicolepierce@gmail.com");
        customerRepository.saveAll(Arrays.asList(cust1,cust2));


        // Orders
        Order ord1 = new Order(0, Instant.parse("2025-07-29T13:18:45Z"), TipoPedidoEnum.Presencial, StatusPedidoEnum.EmPreparo,cust1);
        Order ord2 = new Order(0, Instant.parse("2025-07-29T15:25:30Z"), TipoPedidoEnum.Presencial, StatusPedidoEnum.Pronto,cust2);
        orderRepository.saveAll(Arrays.asList(ord1,ord2));

        Payment pay1 = new Payment(null, Instant.parse("2025-07-29T13:18:45Z"), ord1);
        Payment pay2 = new Payment(null, Instant.parse("2025-07-29T15:25:30Z"), ord2);
        ord1.setPayment(pay1);
        ord2.setPayment(pay2);
        orderRepository.saveAll(Arrays.asList(ord1,ord2));

        
        // Restaurants
        Restaurant restau1 = new Restaurant(0, "Alto Nero - Unidade Av.Paulista", "Av. Paulista, 2295 – Bela Vista, São Paulo – SP");
        Restaurant restau2 = new Restaurant(0, "Alto Nero - Unidade Piinheiros", "Rua dos Pinheiros, 661 – Pinheiros, São Paulo – SP");
        restaurantRepository.saveAll(Arrays.asList(restau1,restau2));

        
        // Pratos
        PratoItem menuItm1 = new PratoItem(0, "Vieiras Seladas ao Purê de Ervilhas Trufado", 25.00, "Com pó de jamón ibérico e azeite de manjericão.", MenuItemEnum.ENTRADA);
        PratoItem menuItm2 = new PratoItem(0, "Carpaccio de Beterraba Defumada", 25.00, "Finalizado com creme de kefir, pistache caramelizado e vinagrete cítrica.", MenuItemEnum.ENTRADA);
        PratoItem menuItm3 = new PratoItem(0, "Risoto Nero com Lagostins Grelhados", 65.00, "Arroz arbório ao nero di seppia com espuma de limão siciliano.",MenuItemEnum.PRATOS_PRINCIPAIS);
        PratoItem menuItm4 = new PratoItem(0, "Codorna Recheada com Mousseline de Castanhas", 74.00, "Servida com glacê de vinho do Porto e microlegumes tostados.",MenuItemEnum.PRATOS_PRINCIPAIS);
        PratoItem menuItm5 = new PratoItem(0, "Tornedor de Filé com Crosta de Cogumelos Selvagens", 80.00, "Acompanhado de purê de mandioquinha e molho demi-glace de trufas negras.", MenuItemEnum.PRATOS_PRINCIPAIS);
        PratoItem menuItm6 = new PratoItem(0, "Ravioli de Pêra e Gorgonzola ao Beurre Noisette", 62.00, "Com amêndoas laminadas e pétalas de flores comestíveis.", MenuItemEnum.PRATOS_PRINCIPAIS);
        PratoItem menuItm7 = new PratoItem(0, "Nhoque de Batata Roxa ao Creme de Castanha-do-Pará", 95.00, "Com pesto de rúcula e farofa de semente de girassol.", MenuItemEnum.VEGANA);
        PratoItem menuItm8 = new PratoItem(0, "Seleção Alto Nero de Queijos Artesanais Brasileiros", 35.00, "Com geleia de hibisco, brioche tostado e pó de azeitona preta.", MenuItemEnum.SOBREMESA);
        PratoItem menuItm9 = new PratoItem(0, "Entremet de Framboesa e Chocolate Branco com Rosas", 35.00, "Sob base crocante de nougat e gelée de pétalas cristalizadas.", MenuItemEnum.SOBREMESA);
        PratoItem menuItm10 = new PratoItem(0, "Tuille de Cacau com Sorvete de Fava Tonka", 40.00, "Finalizado com redução de balsâmico doce e flor de sal.", MenuItemEnum.SOBREMESA);
        pratoItemRepository.saveAll(Arrays.asList(menuItm1, menuItm2, menuItm3, menuItm4, menuItm5, menuItm6, menuItm7, menuItm8, menuItm9, menuItm10));


        // Bebidas
        DrinksItem drink1 = new DrinksItem(0, "Noir Negroni", 42.00, "Gin artesanal, vermute envelhecido, bitter de cacau e toque de lavanda.", DrinksEnum.ALCOÓLICOS);
        DrinksItem drink2 = new DrinksItem(0, "Aurora do Cerrado", 40.00, "Cachaça premium, maracujá fresco, limão-cravo e espuma de capim-limão.", DrinksEnum.ALCOÓLICOS);
        DrinksItem drink3 = new DrinksItem(0, "Vento de Piemonte", 46.00, "Espumante brut, licor de amêndoas, redução de framboesa e raspas de limão-siciliano.", DrinksEnum.ALCOÓLICOS);
        DrinksItem drink4 = new DrinksItem(0, "Orvalho de Jasmim", 44.00, "Vodca infusa com flores de jasmim, lichia, suco de maçã verde e gelo translúcido.", DrinksEnum.ALCOÓLICOS);
        DrinksItem drink5 = new DrinksItem(0, "Tango Noturno", 48.00, "Rum escuro, purê de tamarindo, angostura, mel defumado e casca de laranja flamejada.", DrinksEnum.ALCOÓLICOS);
        DrinksItem drink6 = new DrinksItem(0, "Jardim Silvestre", 28.00, "Chá branco gelado com essência de rosas, morangos frescos e manjericão.", DrinksEnum.NÃO_ALCOÓLICOS);
        DrinksItem drink7 = new DrinksItem(0, "Espuma Tropical", 30.00, "Maracujá, manga e gengibre com água com gás e cobertura de hortelã batida.", DrinksEnum.NÃO_ALCOÓLICOS);
        DrinksItem drink8 = new DrinksItem(0, "Pôr-do-Sol Alto Nero", 32.00, "Suco de acerola, laranja-baía e hibisco, servido com gelo esférico de frutas.", DrinksEnum.NÃO_ALCOÓLICOS);
        DrinksItem drink9 = new DrinksItem(0, "Espresso Nero", 18.00, "Blend exclusivo de grãos brasileiros com infusão de cacau e especiarias quentes.", DrinksEnum.NÃO_ALCOÓLICOS);
        DrinksItem drink10 = new DrinksItem(0, "Licor de Baru com Baunilha do Quilombo", 36.00, "Servido em taça resfriada, com aroma defumado e final persistente.", DrinksEnum.NÃO_ALCOÓLICOS);
        drinksRepository.saveAll(Arrays.asList(drink1,drink2,drink3,drink4,drink5,drink6,drink7,drink8,drink9,drink10));

        OrdemItem orditm1 = new OrdemItem(ord1, menuItm5, 2, menuItm5.getPrice());
        ordemItmRepository.save(orditm1);
    }
}

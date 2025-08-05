# 🍽️ Restaurante API - Spring Boot

Este projeto é uma API RESTful para gerenciamento de um restaurante, desenvolvida em Java com Spring Boot. Ele permite o cadastro e gerenciamento de restaurantes, clientes, reservas de mesas, pedidos, pratos, bebidas e pagamentos.
<br>
<br>

## 🛠️ Funcionalidades

- **Restaurantes:** Cadastro, listagem, atualização e remoção de restaurantes.
- **Clientes:** Cadastro, listagem, atualização e remoção de clientes.
- **Reservas:** Reservar, listar, atualizar e cancelar reservas de mesas.
- **Pedidos:** Criar, listar, atualizar e remover pedidos.
- **Pratos e Bebidas:** Cadastro e gerenciamento do cardápio (pratos e bebidas).
- **Pagamentos:** Registro de pagamentos vinculados aos pedidos.
- **Relacionamentos:**
  - Clientes podem ter reservas e pedidos.
  - Pedidos podem conter vários itens (pratos e bebidas).
  - Cada pedido pode ter um pagamento associado.
<br>
<br>

## 💻 Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database (ambiente de teste)
- Maven
- Postman (para testes de API)
- PostgreSQL
<br>
<br>

## 🛢️ Banco de Dados

O projeto utiliza o banco de dados H2 em memória para o perfil de teste (`test`). As configurações do banco de dados estão no arquivo [`application-test.properties`](../../../../../c:/Users/55119/Desktop/restaurante/demo/src/main/resources/application-test.properties ).

Para configurar um banco de dados diferente (ex: MySQL, PostgreSQL), você deve:

1.  Adicionar as dependências do driver JDBC no `pom.xml`.
2.  Configurar as propriedades de conexão no arquivo `application.properties` (ou criar um arquivo de configuração específico para o seu ambiente, como `application-dev.properties`).

Exemplo de configuração para PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/restaurants
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
<br>
<br>

## ⚙️ Como Executar

- Pré-requisitos: Java 21+ e Maven instalados.
- Clonar o repositório:
```
git clone <url-do-repositorio>
cd demo
```
- Acessar o H2 Console (opcional, apenas para o perfil test):
 
1. URL: http://localhost:8080/h2-console
2. JDBC URL: jdbc:h2:mem:testdb
3. Usuário: sa (sem senha)
<br>
<br>

## 🌐 Endpoints Disponíveis

- restaurants - `GET, POST, DELETE e PUT`.
- customers - `GET, POST, DELETE e PUT`.
- drinks - `GET, POST, DELETE e PUT`.
- pratos - `GET, POST, DELETE e PUT`.
- orders - `GET, POST, DELETE e PUT`.
- reservations - `GET, POST, DELETE e PUT`.
<br>
<br>

## 📌 Modelos (Entidades JPA)

- **Restaurant** - Representa um restaurante.
  - `id`: Indentificador único.
  - `name`: Nome do restaurante.
  - `address`: Endereço do restaurante.
- **Customer** - Reprsenta um cliente.
  - `id`: Indentificador único.
  - `name`: Nome do cliente.
  - `email`: Email do cliente.
- **Reservation** - Reprsenta uma reserva de mesa.
  - `id`: Indentificador único.
  - `mesa`: Mesa numerada.
  - `reservadeDate`: Horário da reserva com data.
  - `customer`: Cliente que fez a reserva.
  - `reservationEnum`: Status da reserva (ex: RESERVADO, OCUPADO, LIVRE).
- **Order** - Representa um pedido
  - `id`: Indentificador único.
  - `order_date`: Momento do pedido.
  - `tipo_pedido`: Tipo do pedido (ex: Presencial, Delivery).
  - `status_pedido`: Status do pedido (ex: PENDENTE, EM_PREPARO, PRONTO, ENTREGUE).
  - `reservationEnum`: Status da reserva (ex: RESERVADO, OCUPADO, LIVRE).
  - `customer`: Cliente que fez o pedido.
  - `payment`: Pagamento associado ao pedido.
- **Payment** - Reprsenta um pagamento.
  - `id`: Indentificador único.
  - `moment`: Momento do pagamento.
  - `order`: Pedido associado ao pagamento.
- **Pratoitem** - Reprsenta um prato do cardápio.
  - `id`: Indentificador único.
  - `name`: Nome do prato.
  - `price`: Preço do prato.
  - `description`: Descrição do prato.
  - `menuItemEnum`: Categoria do prato (ex: ENTRADA, PRATO_PRINCIPAL, SOBREMESA).
- **Drinksitem** - Reprsenta uma do cardápio.
  - `id`: Indentificador único.
  - `name`: Nome da bebida.
  - `price`: Preço da bebida.
  - `description`: Descrição da bebida.
  - `drinksEnum`: Tipo da bebida (ex: ALCOÓLICA, NÃO_ALCOÓLICA).
- **Ordemitem** - Reprsenta itens que pode estar no pedido (bebidas e pratos).
  - `id`: Indentificador passado pelo **OrdemItemPk**.
  - `quantity`: Quantidade do pedido.
  - `quantity_drinks`: Quantidade da bebida pedida.
  - `price_prato`: Preço do prato.
  - `price_drinks`: Preço do prato.
<br>
<br>

## Seed de Dados
A classe [Test_config]() é responsável por inserir dados de exemplo no banco de dados quando a aplicação é iniciada com o perfil `test`. Isso facilita o desenvolvimento e os testes da aplicação.
<br>
<br>

## 🧰 Requisições com Postman
Para fazer as requisições com o Postman, deverá baixar ele. Caso não tenha, aqui esta o site para baixar: 

***URL***: https://www.postman.com/downloads/

Após a instalção, só fazer as resquisições conforme os **Endpoints** acima.
<br>
<br>

## 💡 Funcionalidades
- CRUD completo para as principais entidades

- Mapeamento JPA com @OneToMany, @ManyToOne, @ManyToMany, @OneToOne

- Banco de dados H2 com console web

- Relacionamentos compostos com chaves primárias compostas (OrderItemPK)

- População de dados iniciais via CommandLineRunner ou data.sql
<br>
<br>

## 🎯 Objetivos do Projeto
- Praticar a construção de APIs RESTful com Spring Boot

- Aplicar conceitos de JPA e relacionamentos entre entidades

- Simular um sistema de gerenciamento de restaurante

- Aplicar os conhecimentos adquiridos em cursos

## 🕵🏻‍♂️ Observações
O projeto utiliza perfil test por padrão, com banco H2 em memória.
Dados de exemplo são carregados automaticamente ao iniciar a aplicação, via Test_config.
As entidades e enums estão em com.example.demo.models e com.example.Enums.
  

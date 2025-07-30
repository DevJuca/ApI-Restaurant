package com.example.demo.models;

import java.io.Serializable;
import java.time.Instant;

import com.example.Enums.StatusPedidoEnum;
import com.example.Enums.TipoPedidoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "America/Sao_Paulo")
    private Instant order_date;

    @Enumerated(EnumType.STRING)
    private TipoPedidoEnum tipo_pedido;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum status_pedido;

    // Construtor sem parâmetros...
    public Order(){}

    // Construtor padrão...
    public Order(long id, Instant order_date, TipoPedidoEnum tipo_pedido, StatusPedidoEnum status_pedido) {
        this.id = id;
        this.order_date = order_date;
        this.tipo_pedido = tipo_pedido;
        this.status_pedido = status_pedido;
    }

    // Getters and Setters...
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Instant order_date) {
        this.order_date = order_date;
    }

    public TipoPedidoEnum getTipo_pedido() {
        return tipo_pedido;
    }

    public void setTipo_pedido(TipoPedidoEnum tipo_pedido) {
        this.tipo_pedido = tipo_pedido;
    }

    public StatusPedidoEnum getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(StatusPedidoEnum status_pedido) {
        this.status_pedido = status_pedido;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
}

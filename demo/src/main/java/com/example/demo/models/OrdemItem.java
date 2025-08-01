package com.example.demo.models;

import java.io.Serializable;

import com.example.demo.models.PK.OrdemItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordem_item")
public class OrdemItem implements Serializable{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrdemItemPk id = new OrdemItemPk();
    private Integer quantity;
    private Double price;

    public OrdemItem(){}

    public OrdemItem(Order order, PratoItem pratoItem, Integer quantity, Double price) {
        id.setOrder(order);
        id.setPratoItem(pratoItem);
        this.quantity = quantity;
        this.price = price;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public PratoItem getPratoItem(){
        return id.getPratoItem();
    }

    public void setPratoItem(PratoItem pratoItem){
        id.setPratoItem(pratoItem);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal(){
        return quantity * price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        OrdemItem other = (OrdemItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}

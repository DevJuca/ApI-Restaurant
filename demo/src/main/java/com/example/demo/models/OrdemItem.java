package com.example.demo.models;

import java.io.Serializable;

import com.example.demo.models.PK.OrdemItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordem_item")
@JsonPropertyOrder({ "quantity", "pratoItem", "quantity_drinks", "drinksItem"}) // Deixa a ordem personalizada da estrutura do Json
public class OrdemItem implements Serializable{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrdemItemPk id = new OrdemItemPk();
    private Integer quantity;
    private Integer quantity_drinks;
    private Double price_prato;
    private double price_drinks;

    public OrdemItem(){}

    public OrdemItem(Order order, PratoItem pratoItem, DrinksItem drinksItem, Integer quantity, Integer quantity_drinks, Double price_prato, Double price_drinks) {
        id.setOrder(order);
        id.setPratoItem(pratoItem);
        id.setDrinksItem(drinksItem);
        this.quantity = quantity;
        this.quantity_drinks = quantity_drinks;
        this.price_prato = price_prato;
        this.price_drinks = price_drinks;
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

    public DrinksItem getDrinksItem(){
        return id.getDrinksItem();
    }

    public void setDrinksItem(DrinksItem drinksItem){
        id.setDrinksItem(drinksItem);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity_drinks() {
        return quantity_drinks;
    }

    public void setQuantity_drinks(Integer quantity_drinks) {
        this.quantity_drinks = quantity_drinks;
    }

    @JsonIgnore
    public Double getPricePrato() {
        return price_prato;
    }

    public void setPricePrato(Double price_prato) {
        this.price_prato = price_prato;
    }

    @JsonIgnore
    public double getPrice_drinks() {
        return price_drinks;
    }

    public void setPrice_drinks(double price_drinks) {
        this.price_drinks = price_drinks;
    }

    public Double getSubTotalPrato(){
        return quantity * price_prato;
    }

    public Double getSubTotalDrinks(){
        return quantity_drinks * price_drinks;
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

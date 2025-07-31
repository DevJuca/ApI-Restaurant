package com.example.demo.models;

import java.io.Serializable;

import com.example.Enums.DrinksEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Drinks")
public class DrinksItem implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double price;
    private String description;
    @Enumerated(EnumType.STRING)
    private DrinksEnum drinksEnum;

    public DrinksItem(){}

    public DrinksItem(long id, String name, Double price, String description, DrinksEnum drinksEnum) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.drinksEnum = drinksEnum;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DrinksEnum getDrinksEnum() {
        return drinksEnum;
    }

    public void setDrinksEnum(DrinksEnum drinksEnum) {
        this.drinksEnum = drinksEnum;
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
        DrinksItem other = (DrinksItem) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

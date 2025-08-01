package com.example.demo.models.PK;

import java.io.Serializable;

import com.example.demo.models.Order;
import com.example.demo.models.PratoItem;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrdemItemPk implements Serializable {
    private static final long serialVersionUID = 1L;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "pratos_id")
    private PratoItem pratoItem;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PratoItem getPratoItem() {
        return pratoItem;
    }

    public void setPratoItem(PratoItem pratoItem) {
        this.pratoItem = pratoItem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((pratoItem == null) ? 0 : pratoItem.hashCode());
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
        OrdemItemPk other = (OrdemItemPk) obj;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (pratoItem == null) {
            if (other.pratoItem != null)
                return false;
        } else if (!pratoItem.equals(other.pratoItem))
            return false;
        return true;
    }

    
}

package com.example.demo.models.PK;

import java.io.Serializable;

import com.example.demo.models.DrinksItem;
import com.example.demo.models.PratoItem;

public class OrdemItemPk implements Serializable{
    private static final long serialVersionUID = 1L;

    private PratoItem pratoItem;

    private DrinksItem drinksItem;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public PratoItem getPratoItem() {
        return pratoItem;
    }

    public void setPratoItem(PratoItem pratoItem) {
        this.pratoItem = pratoItem;
    }

    public DrinksItem getDrinksItem() {
        return drinksItem;
    }

    public void setDrinksItem(DrinksItem drinksItem) {
        this.drinksItem = drinksItem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pratoItem == null) ? 0 : pratoItem.hashCode());
        result = prime * result + ((drinksItem == null) ? 0 : drinksItem.hashCode());
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
        if (pratoItem == null) {
            if (other.pratoItem != null)
                return false;
        } else if (!pratoItem.equals(other.pratoItem))
            return false;
        if (drinksItem == null) {
            if (other.drinksItem != null)
                return false;
        } else if (!drinksItem.equals(other.drinksItem))
            return false;
        return true;
    }

    
}

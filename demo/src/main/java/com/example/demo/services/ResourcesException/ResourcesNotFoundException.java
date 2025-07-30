package com.example.demo.services.ResourcesException;

public class ResourcesNotFoundException extends RuntimeException  {
    
    public ResourcesNotFoundException(Object id){
        super("Recurso não encontrado: " + id);
    }
}

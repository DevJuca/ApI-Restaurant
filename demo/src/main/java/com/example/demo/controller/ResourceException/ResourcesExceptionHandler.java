package com.example.demo.controller.ResourceException;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.services.ResourcesException.DataBaseException;
import com.example.demo.services.ResourcesException.ResourcesNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourcesExceptionHandler {
    
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<StandardError> resourcesException(ResourcesNotFoundException e, HttpServletRequest request ){
            String error = "Resources Not Found";
            HttpStatus status = HttpStatus.NOT_FOUND;
            StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> resourcesException(DataBaseException e, HttpServletRequest request ){
            String error = "Database Error";
            HttpStatus status = HttpStatus.BAD_REQUEST;
            StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
    }
}

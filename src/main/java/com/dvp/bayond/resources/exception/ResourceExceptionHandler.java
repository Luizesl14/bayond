package com.dvp.bayond.resources.exception;

import com.dvp.bayond.service.exception.NullObjectException;
import com.dvp.bayond.service.exception.ObjectConflictException;
import com.dvp.bayond.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError>objectNotFound
            (ObjectNotFoundException e, HttpServletRequest request){
        StandarError err = new StandarError(
                HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ObjectConflictException.class)
    public ResponseEntity<StandarError>objectConflict
            (ObjectNotFoundException e, HttpServletRequest request){
        StandarError err = new StandarError(
                HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(NullObjectException.class)
    public ResponseEntity<StandarError>nullObject
            (ObjectNotFoundException e, HttpServletRequest request){
        StandarError err = new StandarError(
                HttpStatus.NO_CONTENT.value(), e.getMessage(), System.currentTimeMillis()
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(err);
    }
}

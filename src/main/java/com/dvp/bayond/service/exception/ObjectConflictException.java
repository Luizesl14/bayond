package com.dvp.bayond.service.exception;

import java.io.Serial;

public class ObjectConflictException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectConflictException(String msg){
        super(msg);
    }

    public ObjectConflictException(String msg, Throwable cause){
        super(msg, cause);
    }

}

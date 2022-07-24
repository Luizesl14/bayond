package com.dvp.bayond.service.exception;

import java.io.Serial;

public class NullObjectException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NullObjectException(String msg){
        super(msg);
    }

    public NullObjectException(String msg, Throwable cause){
        super(msg, cause);
    }

}

package com.dvp.bayond.resources.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class StandarError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private  Integer status;
    private String msg;
    private Long timeStamp;
}

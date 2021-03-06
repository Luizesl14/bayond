package com.dvp.bayond.domain.enums;

import lombok.Getter;

import java.util.Optional;


@Getter
public enum ClinetType {

    NATURAL_PERSON(1, "Pessoa Fisica"),
    LEGAL_PERSON(2, "Pessoa Jurídica");

    private Integer cod;
    private String description;

    ClinetType(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static  ClinetType toEnum(Integer cod){
        Optional.of(cod).orElse(null);

        for(ClinetType x : ClinetType.values()){
            if(cod.equals(x.getCod()))
                return x;
        }
       throw  new IllegalArgumentException("Codigo invalido!");
    }
}

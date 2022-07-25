package com.dvp.bayond.domain.enums;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum PaymentStatus {

    PENDING(1, "Pendente"),
    SETTLED(2, "Quitado"),
    CANCELED(3, "Cancelado");

    private Integer cod;
    private String description;

    PaymentStatus(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static  PaymentStatus toEnum(Integer cod){
        Optional.of(cod).orElse(null);

        for(PaymentStatus x : PaymentStatus.values()){
            if(cod.equals(x.getCod()))
                return x;
        }
        throw  new IllegalArgumentException("Codigo invalido!");
    }
}

package com.dvp.bayond.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "payment_card")
public class PaymentCard extends Payment {

    @Serial
    private static final long serialVersionUID =1L;

    private Integer installments;

    public PaymentCard(Integer id, Payment status, StoreOrder storeOrder, Integer installments) {
        super(id, status, storeOrder);
        this.installments = installments;
    }

    public PaymentCard() {
        super();
    }
}

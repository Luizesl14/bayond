package com.dvp.bayond.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "store_order")
public class StoreOrder implements Serializable {

    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "storeOrder")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "shipping_id")
    private Address shipping;
}

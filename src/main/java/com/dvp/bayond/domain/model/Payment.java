package com.dvp.bayond.domain.model;

import com.dvp.bayond.domain.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "payment")
public class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer status;

    @OneToOne
    @JoinColumn(name = "store_order_id")
    @MapsId
    private StoreOrder storeOrder;

    public Payment(Integer id, Payment status, StoreOrder storeOrder) {
        this.id = id;
        this.status = status.getId();
        this.storeOrder = storeOrder;
    }

    public Payment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {
        return PaymentStatus.toEnum(this.status);
    }

    public void setStatus(PaymentStatus status) {
        this.status = status.getCod();
    }

    public StoreOrder getStoreOrder() {
        return storeOrder;
    }

    public void setStoreOrder(StoreOrder storeOrder) {
        this.storeOrder = storeOrder;
    }
}

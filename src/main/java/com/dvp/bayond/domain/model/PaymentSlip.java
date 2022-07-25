package com.dvp.bayond.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.util.Date;



@Entity
@Table(name = "payment_slip")
public class PaymentSlip extends Payment{

    @Serial
    private static final long serialVersionUID =1L;

    private Date dueDate;
    private Date paymentDate;

    public PaymentSlip(Integer id, Payment status,
                       StoreOrder storeOrder, Date dueDate, Date paymentDate) {
        super(id, status, storeOrder);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public PaymentSlip() {
        super();
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}

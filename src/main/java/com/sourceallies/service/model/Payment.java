package com.sourceallies.service.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the payments database table.
 * 
 */
@Entity
@Table(name="payments")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PaymentPK id;

	private double amount;

    @Temporal( TemporalType.TIMESTAMP)
	private Date paymentDate;

    public Payment() {
    }

	public PaymentPK getId() {
		return this.id;
	}

	public void setId(PaymentPK id) {
		this.id = id;
	}
	
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
package com.tcs.transaction;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDetails {

	private Date dateOfTransaction;
	private BigDecimal amount;
	private String creditDetails;

	public TransactionDetails() {
		super();
	}

	public TransactionDetails(Date dateOfTransaction, BigDecimal amount, String creditDetails) {
		super();
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
		this.creditDetails = creditDetails;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCreditDetails() {
		return creditDetails;
	}

	public void setCreditDetails(String creditDetails) {
		this.creditDetails = creditDetails;
	}

}

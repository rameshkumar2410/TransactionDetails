package com.tcs.transaction;

import java.math.BigDecimal;

/**
 * TransactionLedger
 * @author Ramesh
 *
 */
public class TransactionLedger {

	private BigDecimal totalExpense;
	private BigDecimal totalIncome;
	private BigDecimal totalSaving;
	private BigDecimal highestSpendings;
	private String highestSpendingMonth;

	public TransactionLedger() {
		super();
	}

	public BigDecimal getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(BigDecimal expense) {
		this.totalExpense = expense;
	}

	public BigDecimal getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(BigDecimal income) {
		this.totalIncome = income;
	}

	public BigDecimal getTotalSaving() {
		return totalSaving;
	}

	public void setTotalSaving(BigDecimal saving) {
		this.totalSaving = saving;
	}

	public BigDecimal getHighestSpendings() {
		return highestSpendings;
	}

	public void setHighestSpendings(BigDecimal highestSpending) {
		this.highestSpendings = highestSpending;
	}

	public String getHighestSpendingMonth() {
		return highestSpendingMonth;
	}

	public void setHighestSpendingMonth(String highestSpendingMonth) {
		this.highestSpendingMonth = highestSpendingMonth;
	}

}

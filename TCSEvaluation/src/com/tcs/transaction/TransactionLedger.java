package com.tcs.transaction;

/**
 * TransactionLedger
 * @author Ramesh
 *
 */
public class TransactionLedger {

	private double totalExpense;
	private double totalIncome;
	private double totalSaving;
	private double highestSpendings;
	private String highestSpendingMonth;

	public TransactionLedger() {
		super();
	}

	public double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public double getTotalSaving() {
		return totalSaving;
	}

	public void setTotalSaving(double totalSaving) {
		this.totalSaving = totalSaving;
	}

	public double getHighestSpendings() {
		return highestSpendings;
	}

	public void setHighestSpendings(double highestSpendings) {
		this.highestSpendings = highestSpendings;
	}

	public String getHighestSpendingMonth() {
		return highestSpendingMonth;
	}

	public void setHighestSpendingMonth(String highestSpendingMonth) {
		this.highestSpendingMonth = highestSpendingMonth;
	}

}

package com.tcs.transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Class to perform Transaction Service
 * 
 * @author Ramesh
 *
 */
public class TransactionService {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TransactionDetails> generateMockTransaction() throws Exception {
		List<TransactionDetails> transactList = new ArrayList<TransactionDetails>();
		transactList.add(new TransactionDetails(getSimpleDateFormat("25-01-2020"), -4000, "SBI MF"));
		transactList.add(new TransactionDetails(getSimpleDateFormat("28-01-2020"), -1740.6, "Stationary"));
		transactList.add(new TransactionDetails(getSimpleDateFormat("25-02-2020"), -2800.3, "Grocery"));
		transactList.add(new TransactionDetails(getSimpleDateFormat("05-03-2020"), 20000.6, "Salary"));
		return transactList;

	}

	/**
	 * Method will provide the TransactionDetails
	 * @return TransactionLedger
	 */
	public TransactionLedger getTransactionDetails() {

		List<TransactionDetails> transactionDataList = null;
		double expense = 0.0;
		double income = 0.0;
		double highestSpending = 0.0;
		String month = null;
		TransactionLedger transactionLedger = null;

		try {
			transactionDataList = generateMockTransaction();
			for (TransactionDetails tranDetail : transactionDataList) {

				if (tranDetail.getAmount() < 0) {
					if (highestSpending > tranDetail.getAmount()) {
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(tranDetail.getDateOfTransaction());
						month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
						highestSpending = tranDetail.getAmount();

					}
					expense = expense + tranDetail.getAmount();
				} else {
					income = income + tranDetail.getAmount();
				}

			}

			double saving = (expense) - (-income);
			transactionLedger = new TransactionLedger();
			transactionLedger.setTotalExpense(expense);
			transactionLedger.setTotalIncome(income);
			transactionLedger.setTotalSaving(saving);
			transactionLedger.setHighestSpendings(highestSpending);
			transactionLedger.setHighestSpendingMonth(month);

			System.out.println("Expense ==" + expense + "  Income== " + income + " Saving   == " + saving
					+ " highestSpending == " + highestSpending + " Month ==" + month);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured inside get transaction details");

		}

		return transactionLedger;
	}

	/**
	 * 
	 * @param dateString
	 * @return Converted Date
	 * @throws Exception
	 */
	public Date getSimpleDateFormat(String dateString) throws Exception {
		Date date = new SimpleDateFormat("DD-MM-yyyy").parse(dateString);
		return date;
	}

	public static void main(String args[]) {

		TransactionService service = new TransactionService();
		service.getTransactionDetails();

	}

}

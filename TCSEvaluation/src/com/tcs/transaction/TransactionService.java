package com.tcs.transaction;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

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
		transactList.add(
				new TransactionDetails(getSimpleDateFormat("28-01-2020"), BigDecimal.valueOf(-1740.6), "Stationary"));
		transactList
				.add(new TransactionDetails(getSimpleDateFormat("25-01-2020"), BigDecimal.valueOf(-4000), "SBI MF"));
		transactList
				.add(new TransactionDetails(getSimpleDateFormat("21-01-2020"), BigDecimal.valueOf(-6000), "SBI MF"));
		transactList
				.add(new TransactionDetails(getSimpleDateFormat("27-02-2020"), BigDecimal.valueOf(-9800.3), "Grocery"));
		transactList
				.add(new TransactionDetails(getSimpleDateFormat("28-02-2020"), BigDecimal.valueOf(-9800.3), "Grocery"));
		transactList
				.add(new TransactionDetails(getSimpleDateFormat("06-03-2020"), BigDecimal.valueOf(20000.6), "Salary"));
		transactList
				.add(new TransactionDetails(getSimpleDateFormat("05-03-2020"), BigDecimal.valueOf(20000.6), "Salary"));
		return transactList;

	}

	/**
	 * Method will provide the TransactionDetails
	 * 
	 * @return TransactionLedger
	 */
	public TransactionLedger getTransactionDetails() {

		Map<String, BigDecimal> highestSpendingMap = new HashMap<String, BigDecimal>();
		List<TransactionDetails> transactionDataList = null;
		BigDecimal expense = BigDecimal.valueOf(0.0);
		BigDecimal income = BigDecimal.valueOf(0.0);
		BigDecimal highestSpending = BigDecimal.valueOf(0.0);
		String month = null;
		TransactionLedger transactionLedger = null;

		try {
			transactionDataList = generateMockTransaction();
			for (TransactionDetails tranDetail : transactionDataList) {
				if (tranDetail.getAmount().compareTo(BigDecimal.ZERO) < 0) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(tranDetail.getDateOfTransaction());
					month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
					if (highestSpendingMap.containsKey(month)) {
						highestSpendingMap.put(month, highestSpending = highestSpending.add(tranDetail.getAmount()));
					} else {
						highestSpending = tranDetail.getAmount();
						highestSpendingMap.put(month, highestSpending);
					}

					expense = expense.add(tranDetail.getAmount());
				} else {
					income = income.add(tranDetail.getAmount());
				}

			}
			
			Optional<Entry<String, BigDecimal>> maxEntry = highestSpendingMap.entrySet().stream()
					.min((Entry<String, BigDecimal> e1, Entry<String, BigDecimal> e2) -> e1.getValue()
							.compareTo(e2.getValue()));
			highestSpending = maxEntry.get().getValue();

			BigDecimal saving = new BigDecimal(String.valueOf(expense)).add(new BigDecimal(String.valueOf(income)));
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
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
		return date;
	}

	public static void main(String args[]) {

		TransactionService service = new TransactionService();
		service.getTransactionDetails();

	}

}

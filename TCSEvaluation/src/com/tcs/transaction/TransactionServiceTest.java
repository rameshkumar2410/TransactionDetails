package com.tcs.transaction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

/**
 * TransactionServiceTest
 * 
 * @author Ramesh
 *
 */
class TransactionServiceTest {

	/**
	 * 
	 * Method to perform all the transaction test cases. getTransactionDetailsTest
	 */
	@Test
	public void getTransactionDetailsTest() {

		TransactionService transactionService = new TransactionService();
		TransactionLedger transactionLedger = transactionService.getTransactionDetails();
		assertTrue(transactionLedger.getTotalIncome().equals(BigDecimal.valueOf(40001.2)));
		assertTrue(transactionLedger.getHighestSpendingMonth().equals("February"));
		assertTrue(transactionLedger.getTotalExpense().equals(BigDecimal.valueOf(-31341.2)));
		assertTrue(transactionLedger.getTotalSaving().equals(BigDecimal.valueOf(8660.0)));
		assertTrue(transactionLedger.getHighestSpendings().equals(BigDecimal.valueOf(-19600.6)));

	}

	/**
	 * Method to perform all the transaction test cases invalid output data.
	 * getTransactionDetailsIncorrectDataTest
	 * 
	 */
	@Test
	public void getTransactionDetailsIncorrectDataTest() {

		TransactionService transactionService = new TransactionService();
		TransactionLedger transactionLedger = transactionService.getTransactionDetails();
		assertFalse(transactionLedger.getTotalIncome().equals(BigDecimal.valueOf(24000.6)));
		assertFalse(transactionLedger.getHighestSpendingMonth().equals("January"));
		assertFalse(transactionLedger.getTotalExpense().equals(BigDecimal.valueOf(-8440.900000000001)));
		assertFalse(transactionLedger.getTotalSaving().equals(BigDecimal.valueOf(11449.699999999997)));
		assertFalse(transactionLedger.getHighestSpendings().equals(BigDecimal.valueOf(-4400.0)));

	}

}

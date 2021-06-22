package com.tcs.transaction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * TransactionServiceTest
 * @author Ramesh
 *
 */
class TransactionServiceTest {

	/**
	 * Method to perform all the transaction test cases.
	 * getTransactionDetailsTest
	 */
	@Test
	public void getTransactionDetailsTest() {

		TransactionService transactionService = new TransactionService();
		TransactionLedger transactionLedger = transactionService.getTransactionDetails();
		assertTrue(transactionLedger.getTotalIncome() == 20000.6);
		assertTrue(transactionLedger.getHighestSpendingMonth().equals("January"));
		assertTrue(transactionLedger.getTotalExpense() == -8540.900000000001);
		assertTrue(transactionLedger.getTotalSaving() == 11459.699999999997);
		assertTrue(transactionLedger.getHighestSpendings() == -4000.0);

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
		assertFalse(transactionLedger.getTotalIncome() == 21000.6);
		assertFalse(transactionLedger.getHighestSpendingMonth().equals("February"));
		assertFalse(transactionLedger.getTotalExpense() == -840.900000000001);
		assertFalse(transactionLedger.getTotalSaving() == 11159.699999999997);
		assertFalse(transactionLedger.getHighestSpendings() == -4300.0);

	}

}

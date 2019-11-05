package com.revature.bankingapplicationdaos;

import java.util.List;

import com.revature.bankingapplicationmodels.BankAccountTransaction;


public interface BankAccountTransactionDao {
	
	BankAccountTransactionDao currentImplementation = new BankAccountTransactionDaoSQL();
	
	BankAccountTransaction findById();

	List<BankAccountTransaction> findByName(String name);
	
	List<BankAccountTransaction> findByAmount(int transactionId);
	
	List<BankAccountTransaction> findAll(int bAcctId);
}

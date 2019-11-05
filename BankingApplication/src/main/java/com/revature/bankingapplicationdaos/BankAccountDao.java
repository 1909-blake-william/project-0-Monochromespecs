package com.revature.bankingapplicationdaos;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.revature.bankingapplicationmodels.BankAccount;
import com.revature.bankingapplicationmodels.BankAccountTransaction;
import com.revature.bankingapplicationmodels.BankAccountType;
import com.revature.bankingapplicationprompts.BankingApplicationMainMenuPrompt;

public interface BankAccountDao {
	
	BankAccountDao currentImplementation = new BankAccountDaoSQL();
	
	int save(BankAccount bAcct);

	List<BankAccount> findAll();

	List<BankAccount> findByName(String bankAccountName);

	List<BankAccount> findByTypeId(int bankAccountTypeId);

	BankAccount findById(int bankAccountId);

	void deactivate(int bankAccountId);
	
	void deposit(int amount);
	
	void withdraw(int bAcctBal);
	
	int viewAccountBalance(int bankAccountId);
	
	List<BankAccountTransaction> viewTransactionHistory(int bankAccountId);
}

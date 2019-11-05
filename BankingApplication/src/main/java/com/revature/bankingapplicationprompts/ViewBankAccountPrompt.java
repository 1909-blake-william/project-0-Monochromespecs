package com.revature.bankingapplicationprompts;

//import com.revature.bankingapplicationmodels.BankAccount;

import java.util.List;

import com.revature.bankingapplicationdaos.BankAccountDao;

public class ViewBankAccountPrompt implements BankingApplicationPrompt {

	private BankAccountDao bAcctDao = BankAccountDao.currentImplementation;
	
	@Override
	public BankingApplicationPrompt run() {
		
		List<BankAccountDao> allBankAccounts = bAcctDao.findAll();
		
		for (BankAccountDao bAcct : allBankAccounts){
			if (bAcct.equals(null)){
				System.out.println("Sorry; you don't have an account yet.");
				return new BankingApplicationMainMenuPrompt();
			}
			else
				System.out.println(bAcct);
		}
		return new BankingApplicationMainMenuPrompt();
	}	
}

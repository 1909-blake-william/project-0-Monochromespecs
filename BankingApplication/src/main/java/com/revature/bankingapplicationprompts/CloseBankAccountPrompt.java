package com.revature.bankingapplicationprompts;

import java.util.Scanner;

import com.revature.bankingapplicationdaos.BankAccountDao;
import com.revature.bankingapplicationdaos.BankAccountTypeDao;
import com.revature.bankingapplicationutil.AuthUtil;

public class CloseBankAccountPrompt implements BankingApplicationPrompt {

	private Scanner sc = new Scanner(System.in);
	private BankAccountTypeDao bankAccountTypesDao = BankAccountTypeDao.currentImplementation;
	
	@Override
	public BankingApplicationPrompt run() {

		System.out.println("Would you like to close your account? ");
		// if user is an admin, allow to remove
		// if admin removes, change account status and place into "deactivated" table 
		
		return new BankingApplicationMainMenuPrompt();
	}

}

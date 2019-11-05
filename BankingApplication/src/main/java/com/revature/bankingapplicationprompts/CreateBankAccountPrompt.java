package com.revature.bankingapplicationprompts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import com.revature.bankingapplicationdaos.BankAccountDao;
import com.revature.bankingapplicationdaos.BankAccountDaoSQL;
import com.revature.bankingapplicationdaos.BankAccountTypeDao;
import com.revature.bankingapplicationdaos.BankAccountTypeDaoSQL;
import com.revature.bankingapplicationmodels.BankAccount;
import com.revature.bankingapplicationmodels.BankAccountType;
import com.revature.bankingapplicationmodels.BankingApplicationUser;
import com.revature.bankingapplicationutil.AuthUtil;

public class CreateBankAccountPrompt implements BankingApplicationPrompt {

	private Scanner sc = new Scanner(System.in);
	private BankAccountTypeDao bankAccountTypesDao = BankAccountTypeDao.currentImplementation;
	private BankAccountDao bankAccountDao = BankAccountDao.currentImplementation;
	private AuthUtil authUtil = AuthUtil.instance;

	public BankingApplicationPrompt run() {

		List<BankAccountType> bAcctTypes = bankAccountTypesDao.findAll();

		System.out.println("What type of bank account would you like? ");
		System.out.println("Select bank account type: ");

		for (int i = 0; i < bAcctTypes.size(); i++) {
			System.out.println("Enter " + i + " for " + bAcctTypes.get(i).getName());
		}	
		int typeSelection = sc.nextInt();
		BankAccountType type = bAcctTypes.get(typeSelection);

		System.out.println("Enter beginining balance: ");
		sc.nextLine();
		
		int balance = sc.nextInt();

		BankAccount bAcct = new BankAccount(1, balance, type, authUtil.getCurrentUser());
		bankAccountDao.save(bAcct);
		return new BankingApplicationMainMenuPrompt();
	}
}
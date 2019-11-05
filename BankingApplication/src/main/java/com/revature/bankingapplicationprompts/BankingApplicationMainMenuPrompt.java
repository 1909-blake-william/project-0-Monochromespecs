package com.revature.bankingapplicationprompts;

import java.util.Scanner;

public class BankingApplicationMainMenuPrompt implements BankingApplicationPrompt {

	@Override
	public BankingApplicationPrompt run() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1 to view account information: ");
		System.out.println("Enter 2 to create an account: ");
		System.out.println("Enter 3 to close the account: ");
		
		String selection = sc.nextLine();
		
		switch (selection) {
		case "1":
			return new ViewBankAccountPrompt();
		case "2":
			return new CreateBankAccountPrompt();
		case "3":
			return new CloseBankAccountPrompt();
		default:
			System.out.println("Invalid selection; try again.");
			break;
		}
		return this;
	}
}

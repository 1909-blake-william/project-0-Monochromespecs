package com.revature.bankingapplicationdriver;

import org.apache.log4j.Logger;

import com.revature.bankingapplicationprompts.BankingApplicationLoginPrompt;
import com.revature.bankingapplicationprompts.BankingApplicationPrompt;

public class BankAccountDriver {

	private static Logger log = Logger.getRootLogger();
	 
	public static void main(String[] args) {
		
		BankingApplicationPrompt bAppPrompts = new BankingApplicationLoginPrompt();

		while (true) {

			bAppPrompts = bAppPrompts.run();
		}

	}
}

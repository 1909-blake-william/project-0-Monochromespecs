package com.revature.bankingapplicationprompts;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bankingapplicationdaos.BankingApplicationUserDao;
import com.revature.bankingapplicationmodels.BankingApplicationUser;
import com.revature.bankingapplicationprompts.BankingApplicationMainMenuPrompt;
import com.revature.bankingapplicationprompts.BankingApplicationPrompt;
import com.revature.bankingapplicationutil.AuthUtil;

public class BankingApplicationLoginPrompt implements BankingApplicationPrompt {

	private Logger log = Logger.getRootLogger();
	private Scanner sc = new Scanner(System.in);
	private BankingApplicationUserDao bAppUserDao = BankingApplicationUserDao.currentImplementation;
	private AuthUtil authUtil = AuthUtil.instance;

	/**
	 * gather user input for logging in or registering
	 */
	@Override
	public BankingApplicationPrompt run() {
		System.out.println("Enter 1 to login");
		System.out.println("Enter 2 to register");
		String choice = sc.nextLine();
		switch (choice) {
		case "1": {
			log.debug("Attempting to login");
			System.out.println("Enter username: ");
			String username = sc.nextLine();
			System.out.println("Enter password: ");
			String password = sc.nextLine();

			BankingApplicationUser u = authUtil.login(username, password);
			if (u == null) {
				log.info("Failed to login");
				System.out.println("Please try again");
				break;
			} else {
				log.info("successfully logged in");
				return new BankingApplicationMainMenuPrompt();
			}
		}
		case "2": {
			System.out.println("Enter new username:");
			String username = sc.nextLine();
			BankingApplicationUser bAppUser = bAppUserDao.findByUsername(username);
			if (bAppUser != null) {
				System.out.println("Invalid username");
				break;
			}
			System.out.println("Enter new password:");
			String password = sc.nextLine();
			BankingApplicationUser newBankingApplicationUser = new BankingApplicationUser(1, username, password, "Customer");
			
			// 
			bAppUserDao.save(newBankingApplicationUser);
			break;
		}
		default:
			System.out.println("invalid option");
			break;
		}
		return this;
	}

}
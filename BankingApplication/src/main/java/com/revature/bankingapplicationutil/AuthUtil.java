package com.revature.bankingapplicationutil;

import com.revature.bankingapplicationdaos.BankingApplicationUserDao;
import com.revature.bankingapplicationdaos.BankingApplicationUserDaoSQL;
import com.revature.bankingapplicationmodels.BankingApplicationUser;
import com.revature.bankingapplicationutil.AuthUtil;

public class AuthUtil {
	public static final AuthUtil instance = new AuthUtil();

	private BankingApplicationUserDao userDao = BankingApplicationUserDaoSQL.currentImplementation;
	private BankingApplicationUser currentBankApplicationUser = null;

	private AuthUtil() {
		super();
	}

	public BankingApplicationUser login(String username, String password) {
		BankingApplicationUser u = userDao.findByUsernameAndPassword(username, password);
		currentBankApplicationUser = u;
		return u;
	}

	public BankingApplicationUser getCurrentUser() {
		return currentBankApplicationUser;
	}

}

package com.revature.bankingapplicationdaos;

import java.util.List;

import com.revature.bankingapplicationmodels.BankingApplicationUser;

public interface BankingApplicationUserDao {
	
	BankingApplicationUserDao currentImplementation = new BankingApplicationUserDaoSQL();

	int save(BankingApplicationUser bAppUser);

	List<BankingApplicationUser> findAll();

	BankingApplicationUser findById();

	BankingApplicationUser findByUsernameAndPassword(String username, String password);

	BankingApplicationUser findByUsername(String username);

}

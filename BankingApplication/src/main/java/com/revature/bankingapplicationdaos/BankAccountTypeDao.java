package com.revature.bankingapplicationdaos;

import java.util.List;

import com.revature.bankingapplicationdaos.BankAccountTypeDao;
import com.revature.bankingapplicationmodels.BankAccountType;

public interface BankAccountTypeDao {
	
	BankAccountTypeDao currentImplementation = new BankAccountTypeDaoSQL();

	int save(BankAccountType bAcctType);

	List<BankAccountType> findAll();

	BankAccountType findById(int bAcctTypeId);

	BankAccountType findByName(String name);
	
	

}

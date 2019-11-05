package com.revature.bankingapplicationdaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.bankingapplicationmodels.BankAccountTransaction;
import com.revature.bankingapplicationmodels.BankAccountType;
import com.revature.bankingapplicationmodels.BankAccount;
import com.revature.bankingapplicationutil.ConnectionUtil;

public class BankAccountTransactionDaoSQL implements BankAccountTransactionDao {

	private Logger log = Logger.getRootLogger();

	List<BankAccountTransaction> extractBankAccountTransactions(ResutlSet rs) throws SQLException {
		List<BankAccountTransaction> bAcctTransactions = new ArrayList<>();
		
		while (rs.next()) {
//	public BankAccountTransaction(
			//int bankAccountTransactionId, 
			//int acctBalance, String transactionType,
//		String description, int transactionAmount, 
			//Date date)

			int tranzId = rs.getInt("transaction_id");
			String tranzType = rs.getString("transaction_type");
			String tranzDesc = rs.getString("transaction_desc");
			String tranzAmount = rs.getInt("transaction_amount");
			while(rs.next()){
				bAcctTransactions.add(new BankAccountTransaction(tranzId,tranzType, tranzDesc, tranzAmount, date.getTime());
			}			
		}
		return bAcctTransactions;
	}

	@Override
	public BankAccountTransaction findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccountTransaction> findByName(String transactionType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccountTransaction> findByAmount(int transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccountTransaction> findAll(int bAcctId) {
		log.debug("Attempting to find all bank account transactions from DB");
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bank_account_transactions where bank_account_id =?";

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			return extractBankAccountTransactions(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}

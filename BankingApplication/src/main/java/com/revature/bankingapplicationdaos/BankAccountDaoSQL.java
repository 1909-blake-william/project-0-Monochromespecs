package com.revature.bankingapplicationdaos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.revature.bankingapplicationmodels.BankAccount;
import com.revature.bankingapplicationmodels.BankAccountType;
import com.revature.bankingapplicationmodels.BankingApplicationUser;
import com.revature.bankingapplicationprompts.BankingApplicationMainMenuPrompt;
import com.revature.bankingapplicationutil.AuthUtil;
import com.revature.bankingapplicationutil.ConnectionUtil;


public class BankAccountDaoSQL implements BankAccountDao {

	private BankAccountDao bAcctDao = BankAccountDao.currentImplementation;
	private BankAccountTypeDao bAcctTypeDao = BankAccountTypeDao.currentImplementation;
	private Logger log = Logger.getRootLogger();
	private AuthUtil authorizedUser = AuthUtil.instance;
	
	BankAccountType extractAccountTypes(ResultSet rs) throws SQLException {
			String name = rs.getString("name");
			int id =  rs.getInt("bank_account_types_id");
			return new BankAccountType(id, name);
	}

	private BankAccount extractBankAccount(ResultSet rs) throws SQLException{
		BankAccountDao tempAcct = new BankAccountDaoSQL();
		int bAcctId = rs.getInt("bank_account_id");
		int bAcctBal = rs.getInt("balance");
		String bAcctName = rs.getString("bank_account_type");
		int bAcctTypeId = rs.getInt("bank_account_type_id");
		BankAccountType currentType = bAcctTypeDao.findById(bAcctTypeId);
		return new BankAccount(bAcctId, bAcctBal, currentType, authorizedUser.getCurrentUser());
	}
	
	@Override
	public int save(BankAccount p) {
		
		return 0;
	}

	@Override
	public List<BankAccount> findAll() {
		log.debug("Attempting to find all bank account types from the DB");
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bank_account_types";

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int typeId = rs.getInt("bank_account_type_id");
			String typeName = rs.getString("name");
			
//			List<BankAccount> temp = new ArrayList<>();
//			for (BankAccount aAcct : temp){
//				temp.add(new BankAccount(typeId,typeName));
//			}
			
			return extractBankAccount(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public List<BankAccount> findByName(String bAcctName) {

		try (Connection c = ConnectionUtil.getConnection()) {
			List<BankAccount> aBacct = new ArrayList<>();
			String sql = "SELECT * FROM Bank_account where bank_account_name =?";

			PreparedStatement ps = c.prepareStatement(sql);
//			ps.setInt(1, bAcctId);

			ResultSet rs = ps.executeQuery();
			ps.setString(1, bAcctName);
	
			int acctId = rs.getInt("bank_account_id");
			String acctName = rs.getString("bank_account_name");
			String acctType = rs.getString("bank_account_type_id");
			String acctBal = rs.getString("balance");
//			
			while (rs.next()) {
				aBacct.add(new BankAccount(acctId, acctName, acctType, acctBal));
			}
			return aBacct;

		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
		}

		
		return null;
	}

	@Override
	public List<BankAccount> findByTypeId(int bankAcctTypeId) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM BankAccount WHERE bank_account_id = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, bankAcctTypeId);

			ResultSet rs = ps.executeQuery();
			
			List<BankAccount> aBacct = new ArrayList<>();
			while (rs.next()) {
				aBacct.add();
			}
			return aBacct;

		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
		}
//		return null;
	}

	@Override
	public BankAccount findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deactivate(int bankAccountId) {
		
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM Bank_Account where bank_account_id=?";

			PreparedStatement ps = c.prepareStatement(sql);
			//set the account id, for the prepared statement, to that that's passed in
			ps.setInt(1, bankAccountId);
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
			sql = "DELETE FROM bank_account WHERE bank_account_id=?";
			ps.executeUpdate(sql);
			
			if (rs.next()){
				System.out.println("Account deleted");;
			} else
				return ;
		} catch (SQLException e) {
			System.out.println("Having connection issues; give it a sec, then try again.");
		}
		
	}

	@Override
	public void deposit(int amount) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT bank_account_id, balance FROM Bank_Account";

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int bal = rs.getInt("balance");
			int tempBal = bal + amount;
			ps.setInt(2, tempBal);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Having connection issues; give it a sec, then try again.");
		} 
		return ;
	}

	@Override
	public void withdraw(int amount) {
		
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT bank_account_id, balance FROM Bank_Account";

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int acctBal = rs.getInt("balance");
			
			if (acctBal <= 0) {
				System.out.println("No balance left on the account.");
			} else 
				acctBal -= amount;

		} catch (SQLException e) {
			System.out.println("Having connection issues; give it a sec, then try again.");
			
		}
	}
	@Override
	public int viewAccountBalance(int bankAccountId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BankAccountTransaction viewTransactionHistory(int bankAccountId) {
		
		return null;
	}	
}
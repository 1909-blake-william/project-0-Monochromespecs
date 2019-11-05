package com.revature.bankingapplicationdaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.bankingapplicationmodels.BankAccountType;
import com.revature.bankingapplicationutil.ConnectionUtil;

public class BankAccountTypeDaoSQL implements BankAccountTypeDao {

	private Logger log = Logger.getRootLogger();
	
	List<BankAccountType> extractAccountTypes(ResultSet rs) throws SQLException {
		List<BankAccountType> bAcctTypes = new ArrayList<>();
		
		while (rs.next()) {
			String name = rs.getString("name");
			int id = rs.getInt("bank_account_types_id");
			bAcctTypes.add(new BankAccountType(id, name));
		}
		return bAcctTypes;
	}
	
	@Override
	public List<BankAccountType> findAll() {
		log.debug("Attempting to find all bank accounts from the DB");
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bank_account_types";

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			return extractAccountTypes(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public BankAccountType findById(int bAcctTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountType findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(BankAccountType bAcctType) {
		// TODO Auto-generated method stub
		return 0;
	}

}

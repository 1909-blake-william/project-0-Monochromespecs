package com.revature.bankingapplicationdaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.revature.bankingapplicationmodels.BankingApplicationUser;
import com.revature.bankingapplicationutil.ConnectionUtil;

public class BankingApplicationUserDaoSQL implements BankingApplicationUserDao {

	private Logger log = Logger.getRootLogger();

	BankingApplicationUser extractUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("user_id");
		String rsUsername = rs.getString("username");
		String rsPassword = rs.getString("password");
		String role = rs.getString("role");
		return new BankingApplicationUser(id, rsUsername, rsPassword, role);
	}

	@Override
	public int save(BankingApplicationUser bAppUser) {
		log.debug("Attempting to find user by credentials from the DB");
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO bank_account_users (user_id, username, password) "
					+ " VALUES (bank_account_users_id_seq.nextval,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, bAppUser.getUsername());
			ps.setString(2, bAppUser.getPassword());

			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}

	@Override
	public List<BankingApplicationUser> findAll() {
		log.debug("Attempting to find all users from the DB");
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bank_account_users";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<BankingApplicationUser> bAppUsers = new ArrayList<BankingApplicationUser>();
			while (rs.next()) {
				bAppUsers.add(extractUser(rs));
			}

			return bAppUsers;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public BankingApplicationUser findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankingApplicationUser findByUsernameAndPassword(String username, String password) {
		log.debug("Attempting to find user by credentials from the DB");
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bank_account_users " + "WHERE username = ? AND password = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return extractUser(rs);
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public BankingApplicationUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.revature.bankingapplicationmodels;

import java.math.BigDecimal;

public class BankAccount {

	private int bankAccountId;
	private int balance;
	private BankAccountType type;
	private BankingApplicationUser bAppUserId;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int bankAccountId, int balance, BankAccountType type, BankingApplicationUser bAppUserId) {
		super();
		this.bankAccountId = bankAccountId;
		this.balance = balance;
		this.type = type;
		this.bAppUserId = bAppUserId;
	}

	public int getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public BankAccountType getType() {
		return type;
	}

	public void setType(BankAccountType type) {
		this.type = type;
	}

	public BankingApplicationUser getbAppUserId() {
		return bAppUserId;
	}

	public void setbAppUserId(BankingApplicationUser bAppUserId) {
		this.bAppUserId = bAppUserId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bAppUserId == null) ? 0 : bAppUserId.hashCode());
		result = prime * result + balance;
		result = prime * result + bankAccountId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (bAppUserId == null) {
			if (other.bAppUserId != null)
				return false;
		} else if (!bAppUserId.equals(other.bAppUserId))
			return false;
		if (balance != other.balance)
			return false;
		if (bankAccountId != other.bankAccountId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "BankAccount [bankAccountId=" + bankAccountId + ", balance=" + balance + ", type=" + type
				+ ", bAppUserId=" + bAppUserId + "]";
	}	
}
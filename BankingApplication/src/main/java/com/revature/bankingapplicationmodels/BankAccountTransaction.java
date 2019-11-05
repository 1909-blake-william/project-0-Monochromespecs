package com.revature.bankingapplicationmodels;

import java.sql.Timestamp;
import java.util.Date;

public class BankAccountTransaction {
	
	int bankAccountTransactionId;
	int acctBalance;
	String transactionType;
	String description;
	int transactionAmount;
	Date date;
	
	public BankAccountTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccountTransaction(int bankAccountTransactionId, int acctBalance, String transactionType,
			String description, int transactionAmount, Timestamp timestamp) {
		super();
		this.bankAccountTransactionId = bankAccountTransactionId;
		this.acctBalance = acctBalance;
		this.transactionType = transactionType;
		this.description = description;
		this.transactionAmount = transactionAmount;
		this.date = timestamp;
	}

	public BankAccountTransaction(int acctBalance, String transactionType, String description, int transactionAmount,
			Date date) {
		super();
		this.acctBalance = acctBalance;
		this.transactionType = transactionType;
		this.description = description;
		this.transactionAmount = transactionAmount;
		this.date = date;
	}

	public int getBankAccountTransactionId() {
		return bankAccountTransactionId;
	}

	public void setBankAccountTransactionId(int bankAccountTransactionId) {
		this.bankAccountTransactionId = bankAccountTransactionId;
	}

	public int getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(int acctBalance) {
		this.acctBalance = acctBalance;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acctBalance;
		result = prime * result + bankAccountTransactionId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + transactionAmount;
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
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
		BankAccountTransaction other = (BankAccountTransaction) obj;
		if (acctBalance != other.acctBalance)
			return false;
		if (bankAccountTransactionId != other.bankAccountTransactionId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (transactionAmount != other.transactionAmount)
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccountTransaction [bankAccountTransactionId=" + bankAccountTransactionId + ", acctBalance="
				+ acctBalance + ", transactionType=" + transactionType + ", description=" + description
				+ ", transactionAmount=" + transactionAmount + ", date=" + date + "]";
	}

}

package model.entities;

import model.exception.BusinesException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		/*chama o metodo para validar o saque, fazendo com que a função withdraw lance a excessão*/
		validateWithdraw(amount);
		balance -= amount;
		
	}
	
	//private para deixa ela disponivel apensa nessa classe
	private void validateWithdraw(double amount) {
		if(amount > getWithdrawLimit()) {
			//throw corta o metodo
			throw new BusinesException("Withdraw error: The amount exceeds withdraw limit");
		}
		if(amount > getBalance()) {
			throw new BusinesException("Withdraw error: Not enough balance");
		}
		
	}

		
}

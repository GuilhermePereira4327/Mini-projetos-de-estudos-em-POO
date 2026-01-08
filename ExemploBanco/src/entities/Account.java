package entities;

public class Account {
	
	private int number;
	private String holder;
	private double balance;
	
	public Account(int number, String name) {
		this.number = number;
		this.holder = name;
	}
	
	public Account(int number, String name, double initialBalance) {
		this.number = number;
		this.holder = name;
		deposit(initialBalance);
	}

	public int getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double addBalance) {
		balance += addBalance ;
	}
	
	public void sake(double sake) {
		balance -= sake + 5.0;
	}
	
	public String toString() {
		return "Account " + number + ", Holder: " + holder + ", Balance: $ " + String.format("%.2f", balance);
	}

}

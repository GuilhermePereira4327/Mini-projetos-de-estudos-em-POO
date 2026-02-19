package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.entities.DomainException;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		boolean t = true;
		
		while(t) {
			try {
				System.out.println("Enter account data");
				System.out.print("Number: ");
				int number = sc.nextInt();
				sc.nextLine();
				System.out.print("Holder: ");
				String holder = sc.nextLine();
				System.out.print("Initial balance: ");
				double balanceInitial = sc.nextDouble();
				System.out.print("Withdraw limit: ");
				double withdrawLimit = sc.nextDouble();
				
				Account account = new Account(number, holder, balanceInitial, withdrawLimit);
				
				System.out.println();
				System.out.print("Enter amount for withdraw: ");
				double withdraw = sc.nextDouble();
				account.withdraw(withdraw);
				
				System.out.println(account);
			} 
			catch(DomainException d) {
				System.out.println("Witjdraw erro: " + d.getMessage());
			} 
			catch(RuntimeException r) {
				System.out.println("unexpected error");
			}
			
			System.out.print("\n".repeat(3));
			
			System.out.print("Desejar continuar {y/n}:");
			char continuar = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("\n".repeat(10));
			if(continuar == 'n' || continuar == 'N') {
				t = false;
			}
		}
		
		
		sc.close();
	}

}

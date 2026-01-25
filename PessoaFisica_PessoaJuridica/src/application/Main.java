package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPlayer;
import entities.Company;
import entities.Individual;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPlayer> tax = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n =sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ci = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if(ci == 'i' || ci == 'I') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				tax.add(new Individual(name, anualIncome, healthExpenditures));
			}else {
				System.out.print("Number of employees: ");
				int number = sc.nextInt();
				tax.add(new Company(name, anualIncome, number));
			}
		}
		
		System.out.println();
		
		System.out.println("TAXES PAID: ");
		for(TaxPlayer p: tax) {
			System.out.println(p);
		}
		
		System.out.println();
		
		double sum = 0.0;
		for(TaxPlayer p: tax) {
			sum += p.tax();
		}
		System.out.println("TOTAL TAXEZ: $ " + String.format("%.2f", sum)); 
			
		
		sc.close();
	}

}

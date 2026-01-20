package app;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Dados inicias da Classe Worker
		System.out.print("Enter department´s name: ");
		String departments = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String worklevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, WorkLevel.valueOf(worklevel), baseSalary, new Department(departments));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		//Serve para pegar os dados dos contrados para o HourContract
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String dataString = sc.nextLine();
			LocalDate date = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Value per hour: ");
			Double perHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			sc.nextLine();
			//Serve para adcionar um novo contrato a lista de contratos no HourContract
			worker.addContract(new HourContract(date, perHour, hours));
		}
		
		System.out.println();
		
		//pegar uma data: mes/ano
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthYear = sc.next();
		//dividir a string e passar para duas variaveis de Integer o mes e ano
		int month = Integer.parseInt(monthYear.substring(0, 2));
		int year = Integer.parseInt(monthYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		//Exemplo de composição: worker.getDepartment().getName()
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		sc.close();
	}

}

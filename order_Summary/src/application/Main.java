package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {
	
	public static DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static DateTimeFormatter TIME = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDate = sc.nextLine();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		LocalDateTime now = LocalDateTime.now();
		now.format(TIME);
		Order order = new Order(now, OrderStatus.valueOf(status), new Client(name, email, LocalDate.parse(birthDate, DATE)));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #"+ i +" item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			sc.nextLine();
			
			order.addItem(new OrderItem(quantity, new Product(productName, price)));
		}
		
		System.out.println();
		System.out.println(order);
		
		
		
		sc.close();
	}

}

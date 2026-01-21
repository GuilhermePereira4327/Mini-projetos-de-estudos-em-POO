package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	public static DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static DateTimeFormatter TIME = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> item = new ArrayList<>();
	
	public Order() {
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItem() {
		return item;
	}
	
	public void addItem(OrderItem items) {
		item.add(items);
	}
	
	public void removeItem(OrderItem item) {
		this.item.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for(OrderItem i: item) {
			sum += i.subTotal();
		}
		return sum; 
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + TIME.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " (" +DATE.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
		sb.append("Order items: \n");
		for(OrderItem c: item) {
			sb.append(c + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		
		return sb.toString();
	}
	
}

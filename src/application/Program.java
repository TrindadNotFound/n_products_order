package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program 
{
	public static void main(String[] args) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data");
		
		System.out.print(">> Name: ");
		String name = sc.nextLine();
		
		System.out.print(">> Email: ");
		String email = sc.nextLine();
		
		System.out.print(">> Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		//Intanciar um novo cliente
		Client client = new Client(name, email, birthDate);
		
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
		
		System.out.println("Enter order data");
		System.out.print(">> Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
				
		Order order = new Order(new Date(), status, client);
		
		System.out.println();
		System.out.print("How many items to this order? ");
		int numberOfItems = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= numberOfItems; i++)
		{
			System.out.println("Enter #" + i + " item data");
			System.out.print(">> Product name: ");
			String productName = sc.nextLine();
			System.out.print(">> Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print(">> Quantity: ");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			order.addItem(orderItem);
		}
		
		
		System.out.println();
		
		System.out.println("Order summary");
		System.out.println(order);
		
		sc.close();
	}
}

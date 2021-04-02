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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Mask para formatação da data
		Locale.setDefault(Locale.US); //Assim é possivel utilizar os " . " para separar as casas decimais dos numeros  
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data");
		
		System.out.print(">> Name: ");
		String name = sc.nextLine();
		
		System.out.print(">> Email: ");
		String email = sc.nextLine();
		
		System.out.print(">> Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		/* Depois de serem pedidos todas as informações necesarias ao utilizador é então
		 * instanciado um novo objeto do tipo " Client "
		 */
		
		//Instaciar o objeto cliente
		Client client = new Client(name, email, birthDate);
		
		
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
		
		
		System.out.println("Enter order data");
		System.out.print(">> Status: ");
		
		/* Depois de instaciado o novo cliente, é então definido o estado da encomenda
		 * os varios estados possiveis estão declarados no package " entities.enums "
		 */
		
		//Variavel do tipo OrderStatus onde vai ser armazenado o estado da encomenda
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		/* Feita a declaração da variavel para armazenar o estado da encomenda é então
		 * instaciado um novo objeto do tipo " Order " para armazenar as seguintes informações :
		 * 
		 * >> Data em que foi realizada a encomenda
		 * >> O estado em que ela se encontra
		 * >> O cliente que fez a encomenda
		 * 
		 * */
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
			
			/* Depois de serem introduzidos as informações sobre cada item, é então
			 * instaciado o objeto " product " que contem as informações sobre o item
			 * */
			Product product = new Product(productName, productPrice);
			
			/* Instanciado o objeto " product " é então instanciado um novo objeto ( objeto " orderItem ")
			 * que contem as informaçãoes sobre a encomenda
			 * 
			 * >> Quantas unidade do produto
			 * >> Preço do produto
			 * >> Objeto " product "
			 * */
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			order.addItem(orderItem);
		}
		
		
		System.out.println();
		
		System.out.println("Order summary");
		System.out.println(order); //Chamada do objeto "order" que contem toda a informacao necessaria a ser mostrada ao utilizador
		
		sc.close();
	}
}

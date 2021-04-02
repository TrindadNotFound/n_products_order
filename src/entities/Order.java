package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order 
{

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Um SimpleDateFormat para uma melhor formatacao das datas
	
	//Variaveis da classe
	private Date moment;
	private OrderStatus status;
	
	
	/* Na documentacao fornecida para a elaboracao deste projeto
	 * é indicado que a classe "Order" esta diretamente relacionada com as classes
	 * "OrderItem" e "Client".
	 * 
	 * Neste caso, como cada Order vai ter varios OrderItems, é necessario criar uma List para armazenar
	 * essa informacao
	 * 
	 * */
	
	//Associacao as calsses "Client" e "OrderItem"
	private Client client; //Para a classe Client
	private List<OrderItem> items = new ArrayList<OrderItem>(); //Para a classe OrderItem
	
	
	public Order() //Contrutor
	{
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) //Contrutor
	{
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	//Getter e Setter
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
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

	public List<OrderItem> getOrderItem() {
		return items;
	}
	//------------------------------
	
	
	//Adicionar e remover elementos (items) da lista
	public void addItem(OrderItem item)
	{
		items.add(item);
	}
	
	public void removeItem(OrderItem item)
	{
		items.remove(item);
	}
	
	
	
	public double total() //Funcao para retornar o preco total da Order
	{
		double sum = 0.0;
		
		for(OrderItem o : items)
		{			
			sum += o.subTotal();
		}
		
		return sum;
	}

	@Override
	public String toString() //StringBuilder que permite imprimir no ecra as informacaoes da classe por meio da chamada do objeto order decalrado e intanciado na classe Program
	{
		StringBuilder sb = new StringBuilder();
		sb.append(">> Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append(">> Order status: ");
		sb.append(status + "\n");
		sb.append(">> Client: ");
		sb.append(client + "\n");
		sb.append("\n");
		sb.append(">> Order items:\n");
		
		for (OrderItem item : items)
		{
			sb.append(item + "\n");
		}
		
		sb.append("\n");
		
		sb.append(">> Total price: €");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
	
}

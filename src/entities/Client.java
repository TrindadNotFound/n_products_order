package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client 
{
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat para formatacao das datas apresentadas
	
	private String name;
	private String email;
	private Date birthDate;
	
	public Client() //Construtor
	{
		
	}
	
	public Client(String name, String email, Date birthDate) //Construtor
	{
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	//Getter e Setter
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public Date getBirthDate() 
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate) 
	{
		this.birthDate = birthDate;
	}

	@Override
	public String toString() //toString para imprimir no ecra os dados da classe
	{
		return name + " (" + sdf.format(birthDate) + ") - " + email;
 	}
	
}

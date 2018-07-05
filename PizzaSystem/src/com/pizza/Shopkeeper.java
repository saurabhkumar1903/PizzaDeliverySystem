package com.pizza;
import java.util.*;
import java.io.*;

public class Shopkeeper {
	Pizza pizza;
	//ArrayList<Pizza> pizzalist=new ArrayList<>();
	
	Pizza AddPizza(int pid) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name\ttype\tprice of pizza");
		String name,type;
		double price;
		name=br.readLine();
		type=br.readLine();
		price=Double.parseDouble(br.readLine());
		pizza=new Pizza(pid,name,type,price);
		return pizza;
	}
	void ViewOrder(ArrayList<Order> order)
	{
		System.out.println("All orders Details");
		System.out.println("Order Id  \tPizza list \t Name \t Date \t Amount \tDelivery Status");
		for (Order or:order)
		{
			System.out.print(or.getOid()+"\t \t");
			for(Pizza p:or.getPizza())
			{
				System.out.print(p.getName()+",");
			}
			System.out.print("\t"+or.getCustomer().getCName());
			System.out.println("\t\t"+or.getDate()+"\t"+or.getAmount()+or.getStatus());
			
		}
	}
	
	
}

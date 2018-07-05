package com.pizza;
import java.io.*;

import java.util.*;
import java.util.Map.Entry;
public class Driver {
	public static void main(String args[])throws IOException
	{
		int pid=1;
		int oid=1;
		int ch=1;
		Shopkeeper shop=new Shopkeeper();
		ArrayList<Pizza> pizza=new ArrayList<Pizza>();
		ArrayList<Order> OrderDataBase=new ArrayList<Order>();
		HashMap<Customer,Order> hashmap=new HashMap<>();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		do 
		{	// IN DO MAIN MENU
			
			System.out.println("Welcome to Pizza parlour!");
			System.out.println("Press 1 for shopkeeper \n Press 2 for Customer \n Press -1 to Exit");
			ch=Integer.parseInt(br.readLine());
			switch(ch)
			{
			case 1://in shopkeeper menu
				System.out.println("Welcome Shopkeeper");
				do
				{
					System.out.println("Press 1 to Add Pizza");
					System.out.println("Prss 2 to View Order");
					System.out.println("Press 0 to Return to Main Menu");
					ch=Integer.parseInt(br.readLine());
					switch(ch)
					{
					case 1:
						
						pizza.add(shop.AddPizza(pid++));
						System.out.println("Pizza Added successfully");
						System.out.println("full menu:"+"");
						System.out.println("id \t Name \t Type \t Price");
							for(Pizza p :pizza)
								System.out.println(p.getPid()+"\t"+p.getName()+"\t"+p.getType()+"\t"+p.getPrice());
						break;
					case 2:
						shop.ViewOrder(OrderDataBase);
						break;
					case 0:
						break;
					default:
						break;
					}	
				}while(ch!=0);
			break; //break from shopkeeper menu
			
			case 2: //in customer menu
				Customer customer;
				System.out.println("welcome Customer:");
				System.out.println("Enter your OrderId for old order Else press 0 for New order:");
				int OldOrderId=Integer.parseInt(br.readLine());
				if(OldOrderId==0) //new customer menu does not have a customer id
				{
					int cmchoice;
					do {
						
						
						
						customer=new Customer();
						System.out.println("\nPress 1 to Place Order:");
						System.out.println("Press 0 to Exit");
						cmchoice=Integer.parseInt(br.readLine());
						switch(cmchoice) 
							{
							case 1:
								
								Order op=customer.PlaceOrder(pizza);
								double totalamount=0.0;
								ArrayList<Pizza> OrderePizzainThisORder=op.getPizzalist();
								for(Pizza pl:OrderePizzainThisORder)
								{
									totalamount+=pl.getPrice();
								}
								
								//Order nworder=new Order(++oid,op,"abc",totalamount,name);
								System.out.println("Pizza order Confirmed");
								System.out.println("Your order Id is"+oid);
								op.setOid(oid++);
								op.setAmount(totalamount);
								OrderDataBase.add(op);
								
								break;
							default:
								break;
							}
						}while(cmchoice!=0);
						
				}//clsoe of if new or old customer
				else { //in old customer menu does have a valid customer id and order id
					int cmchoice = 0;
					do {
						
						Order OidAgainstCid = null;
						Customer currentCustomer=new Customer();
						int flag=0;
						Order CurrentOrder=null;
						for(Order oldorder:OrderDataBase)
						{
							
							if(oldorder.getOid()==OldOrderId)
								{
								CurrentOrder=oldorder;
								break;
								}
								
						}
						if(CurrentOrder==null)
							{
							System.out.println("Wrong order id entered.Enter again!! enter -1 to exit");
							OldOrderId=Integer.parseInt(br.readLine());
							if(OldOrderId==-1)
							cmchoice=OldOrderId;
							}
							else
							{
							currentCustomer=CurrentOrder.getCustomer();
							System.out.println("Welcome "+CurrentOrder.getCustomer().getCName());
							System.out.println("PRess 1 to cancel order");
							System.out.println("Press 2 to Find ordre");
							System.out.println("Press 3 to update order");
							System.out.println("Press 4 to receive order");
							System.out.println("Press -1 to Exit");
							cmchoice=Integer.parseInt(br.readLine());
							switch(cmchoice) 
								{
						
								case 1:
									currentCustomer.CancelOrder(OrderDataBase,CurrentOrder);
									cmchoice=-1;
									break;
								case 2:
									currentCustomer.ViewOrder(CurrentOrder);
									break;
								case 3:
									currentCustomer.ViewOrder(CurrentOrder);
									break;
								case 4:
									currentCustomer.ReceiveOrder(CurrentOrder);
									break;
								
								case 5:
									currentCustomer.UpdateOrder(CurrentOrder);
									break;
								default:
									break;
									
								}
						}
						
					}while(cmchoice!=-1);
				}//clsoe of else part for customer who hava a valid id
				break;
				
			default:
					break;
				}
		}while(ch!=-1);
		
			
			
	}
		
	}



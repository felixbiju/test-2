package com.people;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ClientApp {
	
	public static void main(String[] args) {
		
		int choice =0;
		
		Scanner scanner =  new Scanner(System.in);
		 PeopleDaoImpl dao = new PeopleDaoImpl();  
		while (choice !=6)
		{
		System.out.println("People Club Menu");
		System.out.println("1.Add member");
		System.out.println("2.Display all members of the club");
		System.out.println("3.Total Members in each city");
		System.out.println("4.Update member city");
		System.out.println("5.Delete a member based on id");
		System.out.println("6.Exit");
		System.out.println("Enter choice");
		choice= scanner.nextInt();
         switch(choice)
         {
         case 1: 
			{ 
				PeopleClub p=null;
				p=addPeople(); //accept input
			     dao.addPeople(p);
			     break;
			}
         case 2:
         {
        	 List<PeopleClub> people= dao.listAllPeople();
        	 for (PeopleClub p:people) 
        	 {
        		 System.out.println(p);
        		 break;
        	 }
         }
         case 3:
         {
        	 System.out.println("Enter the city name whose members u have to retrieve");
        	 String city=new Scanner(System.in).next() ;
        	 dao.listMembersByCity(city);
        	 break;
        	 
         }
         case 4:
         {
        	 System.out.println("Enter memberid");
        	 int id=new Scanner(System.in).nextInt() ;
        	 System.out.println("Enter new city");
        	 String city=new Scanner(System.in).next();
        	 dao.updateCity(id,city);
        	 break;
         }
         case 5:
         {
        	System.out.println("Enter member id to be deleted");
        	 int id=new Scanner(System.in).nextInt() ;
        	 dao.deletePeople(id);
        	 break;
         }
         }
         }

		
}

	private static PeopleClub listMembersByCity() {
		// TODO Auto-generated method stub
		 String city=null;
		 System.out.println("Enter the name of the City to display its members");
		 Scanner sc=new Scanner(System.in);
		 city=sc.next();
		 PeopleClub p1=new PeopleClub(city);
		return p1;
	}

	private static PeopleClub addPeople() {
		// TODO Auto-generated method stub
		Date dob = null;
		Scanner scanner1=new Scanner(System.in);
	       System.out.println("Enter person first  name");
	       String fname =  scanner1.next();
	       
	       System.out.println("Enter person last name");
	       String lname=scanner1.next();
	       
	       System.out.println("Enter date of Birth in format yyyy-mm-dd");
            String date1=scanner1.next();
            dob=Date.valueOf(date1);
	      
            System.out.println("Enter member city");
	       String city =  scanner1.next();
	      
	       
	       
	       PeopleClub p2=  new PeopleClub(fname,lname,dob,city);
	       return p2;
	       
	
		
	}
}
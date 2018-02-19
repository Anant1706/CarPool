import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test {

	private static  HashMap < String , Customer> Customermap = new HashMap<String , Customer>();
	private  static HashMap < String , Driver> Drivermap = new HashMap<String , Driver>();
	
	private static PoolManager p1  = new PoolManager();
	public static void getridein()
	{
		
		System.out.println("Entering getrinde");
		Scanner sc = new  Scanner(System.in);
		
		for (int i = 0; i < 4; i++)
		{
			String drivername = sc.next();
			
			int number_psg = sc.nextInt();
		
			System.out.println("print inside lopp" +  drivername + "       " + number_psg);
			Cab c1 = new Cab();
			
			Driver d1 = Drivermap.get(drivername);
			c1.driver = d1;
			for(int j  = 0; j < number_psg; j++) {
				
				 int xlocation = sc.nextInt();
				 
				 int ylocation = sc.nextInt();
				 
			 Location desti = new Location(xlocation , ylocation);
			 
             c1.Customer_list.add(desti);
				 
			}
			
		  c1.available_sets = 4- number_psg;
			
			p1.Available_cabs.add(c1);
		}
		System.out.println("Exitign getrinde");
	}
	public static void Calculate_avg_rating(HashMap < String , ArrayList <Ride > >Customerrides , HashMap < String , ArrayList <Ride>>Driverrides) {
		
		
//	  int size = Customerrides.size();
	  Iterator<HashMap.Entry<String, ArrayList<Ride>>> itr = Customerrides.entrySet().iterator();	
	  
	  while(itr.hasNext()) {
		  
		  HashMap.Entry<String , ArrayList<Ride>> entry = itr.next();
		  
		  String Customername = entry.getKey();
		  
		  ArrayList < Ride> rides1 = entry.getValue();
		  
		  int size1 = rides1.size();
		  
		  double avg_cust = 0.0;
		  for(int i = 0; i < size1; i++)
		  {
			   avg_cust  += rides1.get(i).customer_ratings;
			  
		  }
		  
		  avg_cust = avg_cust/size1;
		  
		  Customer c = Customermap.get(Customername);
		  if(c != null)
		  c.setCustomer_ratings(avg_cust);
	  }
	  
	 // System.out.println("Temp1............................................");
	  Iterator < HashMap.Entry<String , ArrayList<Ride> > > itr1 = Driverrides.entrySet().iterator();
	 // System.out.println("Temp1.2...........................................");
	  while(itr1.hasNext()) {
		  
		  
		  
		  HashMap.Entry< String , ArrayList < Ride>> entry = itr1.next();
		  
		  String drivername = entry.getKey();
		  //System.out.println("The value of drivername................" + drivername);
		  ArrayList < Ride> rides1 = entry.getValue();
		  
		  double avg_cust = 0.0;
		  int size1 = rides1.size();
		  for(int i = 0; i < size1; i++)
		  {
			   avg_cust  += rides1.get(i).driver_ratings;
			  
		  }
		  
		  avg_cust = avg_cust/size1;
		 
		  Driver d = Drivermap.get(drivername);
		 // System.out.println(drivername);
		    	d.setdriverrating(avg_cust);
			  
		
	  }
		
	  
	 // System.out.println("End of Calucalte");
	}
	
	public static void main(String [] args) {
		
		ArrayList < Ride> rides = new ArrayList<Ride>() ;
		HashMap < String , ArrayList <Ride>>Driverrides = new HashMap<String , ArrayList<Ride> >();
		HashMap < String , ArrayList <Ride > >Customerrides  = new HashMap<String ,ArrayList< Ride >>(); 
		
	  Scanner sc = new Scanner(System.in);
	  
	   System.out.println("Getting the data of ratings");
	   
	    for (int i = 0; i < 10; i++) {
	    	
	    	String drivername = sc.next();
	    	
	    	int driverrating = sc.nextInt();
	    	
	    	String customername = sc.next();
	    	
	    	int customerrating = sc.nextInt();
	    	
	    	//System.out.println("Printing the data of ratings.....................................................");
	    	//System.out.println(drivername + "   " + driverrating + "     "+ customername + "   "+customerrating); 
	    	
	    	
 	         Customer c1	= new Customer();
	    	 if(Customermap.containsKey(customername))
	         c1 = Customermap.get(customername);
	    	 else {
	    	 c1 = new Customer(customername);
	    	 Customermap.put(customername, c1);
	    	 }
	    	 Driver d1 = null;
	    	 
	    	 if(Drivermap.containsKey(drivername))
	    		 d1 = Drivermap.get(drivername);
	    	 else {
	    		d1 = new Driver(drivername);
	          Drivermap.put(drivername, d1); 
	    	 }
	    	Ride r1 = new Ride(c1, d1, customerrating, driverrating);
	    	rides.add(r1);
	    
	    	
	    	if(Driverrides.containsKey(drivername)) {
	    	ArrayList < Ride> temp1 = Driverrides.get(drivername);	
	    	temp1.add(r1);
	    	}
	    	else
	    	{
	    		ArrayList < Ride> temp1 = new ArrayList <Ride>();
	    		temp1.add(r1);
	    		Driverrides.put(drivername, temp1);
	    	}
	    	
	    	if(Customerrides.containsKey(customername)) {
		    	ArrayList < Ride> temp1 = Customerrides.get(customername);	
		    	temp1.add(r1);
		    	}
		    	else
		    	{
		    		ArrayList < Ride> temp1 = new ArrayList<Ride>();
		    		temp1.add(r1);
		    		Customerrides.put(customername, temp1);
		    	}
	    	
	    
	    }
	  //  sc.close();
	    p1.Available_cabs =  new ArrayList < Cab>();
	    for (int i = 0; i < 4; i++)
		{
			String drivername = sc.next();
			
			int number_psg = sc.nextInt();
		
			//System.out.println("print inside lopp" +  drivername + "       " + number_psg);
			Cab c1 = new Cab();
			
			Driver d1 = Drivermap.get(drivername);
			c1.driver = d1;
			c1.Customer_list = new ArrayList < Location>();
			for(int j  = 0; j < number_psg; j++) {
				
				 int xlocation = sc.nextInt();
				 
				 int ylocation = sc.nextInt();
				 
			 Location desti = new Location(xlocation , ylocation);
			 
             c1.Customer_list.add(desti);
				 
			}
			
		  c1.available_sets = 4- number_psg;
			
			p1.Available_cabs.add(c1);
		}
	   
	     Calculate_avg_rating(Customerrides, Driverrides);
	  
	     Iterator<HashMap.Entry<String, ArrayList<Ride>>> itr = Customerrides.entrySet().iterator();
	     
	     
	      while (itr.hasNext()) {
	    	  
	    	  
	    	  HashMap.Entry<String , ArrayList<Ride>> entry = itr.next();
	    	  
	    	  String customername =   entry.getKey();
	    	  
	    	  Customer c12 =Customermap.get(customername);
	    	 
	    	  ArrayList < Ride> temp1 = new ArrayList<Ride>();
	    	  
	    	  c12.setHistory(entry.getValue());
	      
	      }
	     
	   String  customername = sc.next();
	     
	      Customer c = Customermap.get(customername);
	     int seats_required = sc.nextInt();
	     
	     int xloc = sc.nextInt();
	     
	     int yloc  = sc.nextInt();
	     Location l1 = new Location(xloc, yloc);
	     
	    // System.out.println(customername + " " + seats_required);
	     ArrayList < Cab >list1 = p1.find_available_cab(c, seats_required);
	     
	     
	       if(list1.size() == 0)
	    	System.out.println("Cabs not found");
	       else
	       {
	    	   System.out.println("List of matching cabs  for customer      " + c.get_customer_rating());
	    	   for(int i = 0 ; i < list1.size(); i++) {
	    		   
	    		
	    		   System.out.println(list1.get(i).driver.getdrivername() + "               " + list1.get(i).driver.getRatings());
	    	   }
	       }
	    }
	    
	    
	    
	   
	}


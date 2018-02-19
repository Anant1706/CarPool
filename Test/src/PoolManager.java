import java.util.ArrayList;
import java.util.List;

public class PoolManager {

	
	
	public PoolManager()
	{
		
	}
	ArrayList < Cab> Available_cabs;
	
	
	boolean hasdriverratedone(Customer c)
	{
		
		ArrayList < Ride> temp1 = c.getHistory();
		
		int size1 = temp1.size();
		
		for(int i = 0 ; i < size1; i++) {
			
			
			 if(temp1.get(i).getdriverratings() ==1)
				 return false;
			
			
		}
		
		
		
		return true;
	}
	
	 ArrayList < Cab> find_available_cab(Customer c , int seats_required){
		 //System.out.println("Getting the data of current ab");
		 ArrayList < Cab > result =  new ArrayList < Cab >();
		 
		   // find out the Cabs using first criteria 
		 
		 int size = Available_cabs.size();
		 
		 for(int i = 0 ; i < size; i++)
		 {
			 
			 Cab  Current_cab  = Available_cabs.get(i);
			//  System.out.println("Printing the data " +Current_cab.getDriver().getdrivername() + " " +  Current_cab.getDriver().getRatings() + " " + c.get_customer_rating() );
			//  System.out.println("Printing the data " +   Current_cab.getavailable_seats()+ " " + seats_required );
			  if( Current_cab.getDriver().getRatings() - c.get_customer_rating() >= 0 && Current_cab.getavailable_seats() >=seats_required ) {
			//	 System.out.println("Getting the data of current ab");
				  result.add(Current_cab);
			 
			  }
		 }
		 
		 
		 
		return result; 
	 }
}

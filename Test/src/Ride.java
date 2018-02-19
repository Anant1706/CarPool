
public class Ride {

	  Customer cust;  
	  Driver  d;
	  int customer_ratings;
	  
	  int driver_ratings;
	  
	 public Ride(Customer cust , Driver d,  int customer_ratings , int driver_ratings) {
		 
		 
		 this.cust = cust;
		 this.d = d;
		 this.customer_ratings = customer_ratings;
		 this.driver_ratings = driver_ratings;
		 
		 
	 }
	 
	 public Customer getcustomer()
	 {
		 return cust;
	 }
	 
	 public Driver getdriver() {
		 
		 return d;
	 }
	 
	 public int getCustomerRating()
	 {
		 return customer_ratings;
	 }
	 
	 public int getdriverratings() {
		 return driver_ratings;
	 }
	 
	 
	 
}

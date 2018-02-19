import java.util.ArrayList;

public class Customer {

	 private String name;
	 
	 private double Customer_rating;
	  
	 private ArrayList < Ride> History;
	 Location  Destination;
	 
	 public Customer() {
		 
	 }
	 
	 public Customer (String name) {
		 
		 this.name = name;
		 this.Customer_rating = 0.0;
		 
	 }
	 
	 public double get_customer_rating()
	 {
		 return Customer_rating;
	 }
	 
	 public void setCustomer_ratings(double d1)
	 {
		this.Customer_rating = d1;
	 }
	 
	 public String getcustomername() {
		 return name;
	 }
	 
	 ArrayList < Ride> getHistory()
	 {
	 return History;
	 }
	 
	 public void setHistory(ArrayList <Ride> temp1)
	 {
		 
		 History = temp1;
	 }
	 }


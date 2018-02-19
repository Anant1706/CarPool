
public class Driver {

	 private String Driver_name;
	 
	// private String Driver_id;
	 
	// private String dob;
	 
	// boolean isfree;
	 
	 private double ratings;
	 
	 public double getRatings()
	 {
		 return ratings;
	 }
	 
	 public Driver(String Driver_name)
	 {
		 
		 this.Driver_name = Driver_name;
		 this.ratings = 0.0;
	 }
	 
	 public void setdriverrating(double d1)
	 {
		 
		 this.ratings = d1;
	 }
	 
	 public String getdrivername()
	 {
		 return Driver_name;
	 }
}

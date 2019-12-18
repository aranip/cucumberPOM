package Bean;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson {
	public static void main(String[] a) 
    { 
  
        // Creating object of customer
       Customer customer = new Customer(); 
  
        // Insert the data into the object 
        customer = getObjectData(customer); 
  
        // Creating Object of ObjectMapper define in Jakson Api 
        ObjectMapper Obj = new ObjectMapper(); 
  
        try { 
  
            // get Customer object as a json string 
            String jsonStr = Obj.writeValueAsString(customer); 
  
            // Displaying JSON String 
            System.out.println(jsonStr); 
        } 
  
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
  
    // Get the data to be inserted into the object 
    public static Customer getObjectData(Customer customer) 
    { 
  
        // Insert the data 
    	customer.setId("7");
    	customer.setFirstName("Robert");
    	customer.setLastName("Miller");
    	customer.setStreet("Main St");
    	customer.setCity("Fremont");
         
  
        // Return the object 
        return customer; 
    } 
}

package Bean;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectToJsonAndWriteJsonToAFile {
	public static void main(String[] a) 
    { 
        // Creating object of customer
		Customer customer = new Customer(); 
		  
        // Insert the data into the object 
        customer = getObjectData(customer); 
 
        ObjectMapper mapper = new ObjectMapper(); 
  
        	try {
                mapper.writeValue(new File("result.json"), customer);
        System.out.println("Json file");
            } catch (Exception e) {
                e.printStackTrace();
            }
     
}
	public static Customer getObjectData(Customer customer) 
    { 
  
        // Insert the data 
    	customer.setId("8");
    	customer.setFirstName("Robert");
    	customer.setLastName("Miller");
    	customer.setStreet("Main St");
    	customer.setCity("Fremont");
         
  
        // Return the object 
        return customer; 
    } 
}

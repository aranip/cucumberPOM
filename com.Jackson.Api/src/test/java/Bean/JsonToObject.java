package Bean;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObject {
	 public static void main(String args[]){
         
	        ObjectMapper mapper = new ObjectMapper();
	    Customer cust =null;
	        try {
	            cust = mapper.readValue(new File("result.json"), Customer.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }   
	         
	        System.out.println(cust);
	         
	    }
}

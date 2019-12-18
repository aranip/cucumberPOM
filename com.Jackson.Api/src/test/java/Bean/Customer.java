package Bean;

public class Customer {
	private String id;
	private String firstName, lastName, street, city;
	
 public Customer(){
super();
}

public final String getId() {
	return id;
}

public final void setId(String id) {
	this.id = id;
}

public final String getFirstName() {
	return firstName;
}

public final void setFirstName(String firstName) {
	this.firstName = firstName;
}

public final String getLastName() {
	return lastName;
}

public final void setLastName(String lastName) {
	this.lastName = lastName;
}

public final String getStreet() {
	return street;
}

public final void setStreet(String street) {
	this.street = street;
}

public final String getCity() {
	return city;
}

public final void setCity(String city) {
	this.city = city;
}
@Override
public String toString() 
{ 
	return "Customer [id="
            + id
            + ", firstName="
            + firstName
            +",lastNmae="
            +  lastName
            +",street="
            + street
            + ", city="
            + city + "]"; 
} 
}

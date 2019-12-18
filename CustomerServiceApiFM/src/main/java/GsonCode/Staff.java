package GsonCode;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Staff {

    private String name;
    private int age;
    private String[] position;              // array
    private List<String> skills;            // list
    private Map<String, BigDecimal> salary; // map
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final int getAge() {
		return age;
	}
	public final void setAge(int age) {
		this.age = age;
	}
	public final String[] getPosition() {
		return position;
	}
	public final void setPosition(String[] position) {
		this.position = position;
	}
	public final List<String> getSkills() {
		return skills;
	}
	public final void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public final Map<String, BigDecimal> getSalary() {
		return salary;
	}
	public final void setSalary(Map<String, BigDecimal> salary) {
		this.salary = salary;
	}

    //getters and setters
}
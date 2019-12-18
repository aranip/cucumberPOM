package registrationRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/amruthapenigalapati/eclipse-workspace/corejava/src/Basic_java/com.apex.CucuPOM/src/main/java/com/apex/features/registration.Feature", //the path of the feature files
		glue={"/com/apex/StepDefinition/RegistrationStepDefinition"}, //the path of the step definition files
		plugin = {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		monochrome = true //display the console output in a proper readable format
		)

public class RegistrationRunner {

}

package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/features/amazonLogin.feature"}
		,glue= {"stepDefinitions"},
		plugin = { "pretty", "html:target/test-output", "json:target/json_output/cucumber.json",
        "junit:target/junit_xml/cucumber.xml" })

public class executeAmazonLogin {


}

package cucumberRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitio"},
        		plugin = { "pretty" ,"html:target/cucumber-reports"},
        monochrome = true,
        strict = true
)
public class UserTestRunner  {

}

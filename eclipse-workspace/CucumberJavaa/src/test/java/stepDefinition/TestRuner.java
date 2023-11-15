package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
glue= {"stepDefinition"},
monochrome=true,
plugin= {"pretty","html:target/HtmlReports/report.html"})

public class TestRuner {

}

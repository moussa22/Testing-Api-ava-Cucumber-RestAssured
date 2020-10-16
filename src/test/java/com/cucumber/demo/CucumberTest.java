package com.cucumber.demo;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = {"src/test/resources/features"},tags ={"@Smoke"})
@CucumberOptions(features = "src/test/resources/features/customer.feature", format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, glue = {"com.isacof.stepdefs"})

public class CucumberTest  {
}

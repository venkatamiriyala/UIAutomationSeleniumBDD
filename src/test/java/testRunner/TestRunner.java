package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features/",
        glue="stepDefinitions",
        tags= {"@sanity"},
        	plugin= {"pretty",
        	"html:target/cucumber-html-report",
        	"json:target/cucumber.json", "junit:target/cucumber.xml",
        	"rerun:target/rerun.txt"},
         	 dryRun=false
			)

public class TestRunner {
	
}

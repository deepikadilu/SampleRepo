package runnerTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags= "@RegressionTest",
		features="src/test/resources/Features",
		glue={"stepDefs"},
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json"}
		)
public class SwiggyRunnerTest extends AbstractTestNGCucumberTests {

}

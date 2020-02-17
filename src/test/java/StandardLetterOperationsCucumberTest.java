import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "features/", tags = "@Login, @Spam, @Flag, @Sendletter")
public class StandardLetterOperationsCucumberTest extends AbstractTestNGCucumberTests {}
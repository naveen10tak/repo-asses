import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/ComposeEmail.feature", // path to the feature file
    glue = {"stepdefinitions"}, // package containing step definitions
    plugin = {"pretty", "html:target/cucumber-reports"},
    monochrome = true,
    tags = "@PositiveTest or @NegativeTest"
)
public class TestRunner {
    
}

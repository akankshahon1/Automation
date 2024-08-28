import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        monochrome = true,
        glue= "steps",
        features = "src/test/resources/features/login.feature",
        stepNotifications = true,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"} //Creates a text file with failed scenarios
        ,tags = "@Login"
)
public class TestRunner {

}

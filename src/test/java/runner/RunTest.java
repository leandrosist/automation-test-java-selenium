package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@Regressivo",
        plugin = {
                "pretty",
                "html:target/report-cucumber.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // ADICIONE ESTA LINHA
        }
)
public class RunTest {
}
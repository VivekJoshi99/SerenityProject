package Runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import static io.cucumber.junit.platform.engine.Constants.*;

//@Suite
//@IncludeEngines("cucumber")
//@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:Features")
////@SelectClasspathResource("Features") // Adjust this to your actual feature file location
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@smoke")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "StepDefinitions") // Adjust to your step definitions package
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/cucumber-html-report,summary")

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@smoke",
        plugin = {
                "pretty", "json:target/cucumber-reports/AutomationReport.json"
        },
        glue = "StepDefinitions",
        features = "src/test/resources/Features"
)
public class TestRunnerSerenity {
}

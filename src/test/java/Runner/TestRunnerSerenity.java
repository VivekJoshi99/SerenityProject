package Runner;//package Runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource(".")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@smoke")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "/StepDefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/cucumber-html-report,summary")
public class TestRunnerSerenity {
}
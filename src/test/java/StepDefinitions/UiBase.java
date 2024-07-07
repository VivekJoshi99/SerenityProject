package StepDefinitions;

import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

public class UiBase {
    public static EnvironmentVariables environmentVariables;
    public static String baseUrl;
    static {
        environmentVariables = ConfiguredEnvironment.getEnvironmentVariables();
        environmentVariables.getKeys().forEach(key -> System.out.println(key + ": " + environmentVariables.getProperty(key)));
        baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url");
    }
}

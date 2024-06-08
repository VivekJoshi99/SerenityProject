package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hooks {
    @Before
    public void SetUP(){
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void TearDown(){
        OnStage.drawTheCurtain();
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().close();
        BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().quit();
    }
}

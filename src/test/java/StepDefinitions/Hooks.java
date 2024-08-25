package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static HelperMethods.Helper.getActor;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hooks {
    @Before
    public void SetUP(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("John");
        System.out.println("Actor: " + getActor().getName() + " is entering source station: ");
    }

    @After
    public void TearDown(){
        OnStage.drawTheCurtain();
        BrowseTheWeb.as(getActor()).getDriver().close();
        BrowseTheWeb.as(getActor()).getDriver().quit();
    }
}

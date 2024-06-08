package HelperMethods;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Helper {
    public static Actor actor = theActorInTheSpotlight();
    public static void waitForElementVisibility(int timeout, By by){
        new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementClickable(int timeout, By by){
        new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(by));
    }


}

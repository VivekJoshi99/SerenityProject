package HelperMethods;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Helper {
    public static void waitForElementVisibility(int timeout, By by){
        new WebDriverWait(BrowseTheWeb.as(getActor()).getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementClickable(int timeout, By by){
        new WebDriverWait(BrowseTheWeb.as(getActor()).getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(by));
    }

    public static Actor getActor(){
        return OnStage.theActorInTheSpotlight();
    }

    public static JSONObject readJsonFile(){
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader("scr/test/resources/TestData/Literature.json");
            JSONObject object = (JSONObject) parser.parse(reader);
            reader.close();
            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

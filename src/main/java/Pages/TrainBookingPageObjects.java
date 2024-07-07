package Pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.findby.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class TrainBookingPageObjects extends PageObject {

    public static Target FROM_FIELD = Target.the("FROM_FIELD").locatedBy("txtStationFrom");
    public static Target AUTOSUGGESTIVE_FROM_FIELD = Target.the("AUTOSUGGESTIVE_FROM_FIELD").located(By.xpath("(//div[@class='autocomplete'])[1]/div"));
    public static Target AUTOSUGGESTIVE_TO_FIELD = Target.the("AUTOSUGGESTIVE_TO_FIELD").locatedBy("(//div[@class='autocomplete'])[2]/div");
    public static Target TO_FIELD = Target.the("TO_FIELD").locatedBy("txtStationTo");
    public static Target FROM_FIELD_AUTOSUGGESTION = Target.the("FROM_FIELD_AUTOSUGGESTION").locatedBy("(//div[@class='autocomplete'])[1]/div");
    public static Target TO_FIELD_AUTOSUGGESTION = Target.the("TO_FIELD_AUTOSUGGESTION").locatedBy("(//div[@class='autocomplete'])[2]/div");
    public static Target CALENDER_VIEW_FIELD = Target.the("CALENDER_VIEW_FIELD").locatedBy("//input[@title='Select Departure date for availability']");

    public static void enterFromStation(Actor actor, String from){
        actor.attemptsTo(WaitUntil.the(FROM_FIELD,isVisible()));
        actor.attemptsTo(Click.on(FROM_FIELD));
        actor.attemptsTo(Clear.field(FROM_FIELD));
        actor.attemptsTo(Enter.theValue(from).into(FROM_FIELD));
        actor.attemptsTo(WaitUntil.the(AUTOSUGGESTIVE_FROM_FIELD, isVisible()));
        actor.attemptsTo(Click.on(AUTOSUGGESTIVE_FROM_FIELD.resolveAllFor(actor).get(4)));
    }

    public static void enterToStation(Actor actor, String to){
        actor.attemptsTo(WaitUntil.the(TO_FIELD,isVisible()));
        actor.attemptsTo(Click.on(TO_FIELD));
        actor.attemptsTo(Clear.field(TO_FIELD));
        actor.attemptsTo(Enter.theValue(to).into(TO_FIELD));
        actor.attemptsTo(WaitUntil.the(AUTOSUGGESTIVE_TO_FIELD, isVisible()));
        actor.attemptsTo(Click.on(AUTOSUGGESTIVE_TO_FIELD.resolveAllFor(actor).get(2)));
    }

}

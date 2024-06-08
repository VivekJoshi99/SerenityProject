package Pages;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class TrainBookingPageObjects extends PageObject {

    public static Target FROM_FIELD = Target.the("FROM_FIELD").locatedBy("txtStationFrom");
    public static Target TO_FIELD = Target.the("TO_FIELD").locatedBy("txtStationTo");
    public static Target FROM_FIELD_AUTOSUGGESTION = Target.the("FROM_FIELD_AUTOSUGGESTION").locatedBy("(//div[@class='autocomplete'])[1]/div");
    public static Target TO_FIELD_AUTOSUGGESTION = Target.the("TO_FIELD_AUTOSUGGESTION").locatedBy("(//div[@class='autocomplete'])[2]/div");
    public static Target CALENDER_VIEW_FIELD = Target.the("CALENDER_VIEW_FIELD").locatedBy("//input[@title='Select Departure date for availability']");

}

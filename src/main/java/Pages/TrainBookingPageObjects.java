package Pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TrainBookingPageObjects extends PageObject {

    static String fileName = "./TrainsList.xls";
    static FileInputStream fis;
    static FileOutputStream fos;
    static HSSFWorkbook wb;
    static HSSFSheet sheet;
    static HSSFRow row;

    public static Target FROM_FIELD = Target.the("FROM_FIELD").locatedBy("#txtStationFrom");
    public static Target AUTOSUGGESTIVE_FROM_FIELD = Target.the("AUTOSUGGESTIVE_FROM_FIELD").located(By.xpath("(//div[@class='autocomplete'])[1]/div"));
    public static Target AUTOSUGGESTIVE_TO_FIELD = Target.the("AUTOSUGGESTIVE_TO_FIELD").locatedBy("(//div[@class='autocomplete'])[2]/div");
    public static Target TO_FIELD = Target.the("TO_FIELD").locatedBy("#txtStationTo");
    public static Target FROM_FIELD_AUTOSUGGESTION = Target.the("FROM_FIELD_AUTOSUGGESTION").locatedBy("(//div[@class='autocomplete'])[1]/div");
    public static Target TO_FIELD_AUTOSUGGESTION = Target.the("TO_FIELD_AUTOSUGGESTION").locatedBy("(//div[@class='autocomplete'])[2]/div");
    public static Target CALENDER_VIEW_FIELD = Target.the("CALENDER_VIEW_FIELD").locatedBy("//input[@title='Select Departure date for availability']");
    public static Target CALENDER_VIEW = Target.the("CALENDER_VIEW").locatedBy("#tdDateFromTo input");
    public static Target QUOTA = Target.the("QUOTA").locatedBy("#cmbQuota");
    public static Target SEATCLASS = Target.the("SEATCLASS").locatedBy("#selectClassFilter");
    public static Target GETTRAINS = Target.the("GETTRAINS").locatedBy("#tdTrainFromTo #buttonFromTo");
    public static Target GETTRAINSLISTHEADINGS = Target.the("GETTRAINSLISTHEADINGS").locatedBy(".DataTable.TrainList.TrainListHeader.stickyTrainListHeader>tbody th a");
    public static Target GETTRAINSLIST = Target.the("GETTRAINSLIST").locatedBy(".DataTable.TrainList.TrainListHeader.stickyTrainListHeader>tbody tr:not(:has(th))");
    public static Target TOOLTIPFAREDETAILS = Target.the("TOOLTIPFAREDETAILS").locatedBy("#tooltipFare");
    public static Target TRAINROUTEDETAILSHEADINGS = Target.the("TRAINROUTEDETAILSHEADINGS").locatedBy(".DataTable.DataTableHeader.RouteList tr td");
    public static Target TRAINROUTEDETAILS = Target.the("TRAINROUTEDETAILS").locatedBy("#divRouteList table tr");
    public static Target TRAINTICKET = Target.the("TRAINTICKET").locatedBy("#divFare #aPrint");
    public static Target selectBookingDate(String month_yr, int day){
        return Target.the("Booking Date").locatedBy(String.format("//td[text()='%s']/ancestor::tbody[1]//td[text()=%d]",month_yr, day));
    }
    public static Target getTrainRouteDetails(int rowNum, int coldata){
        return Target.the("Booking Date").locatedBy(String.format("#divRouteList table tr:nth-child(%d) td:nth-child(%d)",rowNum, coldata));
    }
    public static Target selectTrainFromList(int num){
        return Target.the("Train List").locatedBy(String.format(".DataTable.TrainList.TrainListHeader.stickyTrainListHeader>tbody tr:not(:has(th)):nth-child(%d) td:nth-child(2) a", num));
    }

    public static void enterFromStation(Actor actor, String from, int optionFrom){
        actor.attemptsTo(WaitUntil.the(FROM_FIELD,isVisible()));
        actor.attemptsTo(Click.on(FROM_FIELD));
        actor.attemptsTo(Clear.field(FROM_FIELD));
        actor.attemptsTo(Enter.theValue(from).into(FROM_FIELD));
        actor.attemptsTo(WaitUntil.the(AUTOSUGGESTIVE_FROM_FIELD, isVisible()));
        actor.attemptsTo(Click.on(AUTOSUGGESTIVE_FROM_FIELD.resolveAllFor(actor).get(optionFrom)));
    }

    public static void enterToStation(Actor actor, String to, int optionTo){
        actor.attemptsTo(WaitUntil.the(TO_FIELD,isVisible()));
        actor.attemptsTo(Click.on(TO_FIELD));
        actor.attemptsTo(Clear.field(TO_FIELD));
        actor.attemptsTo(Enter.theValue(to).into(TO_FIELD));
        actor.attemptsTo(WaitUntil.the(AUTOSUGGESTIVE_TO_FIELD, isVisible()));
        actor.attemptsTo(Click.on(AUTOSUGGESTIVE_TO_FIELD.resolveAllFor(actor).get(optionTo)));
    }

    public static void enterBookingDate(Actor actor, String month, int day){
        actor.attemptsTo(WaitUntil.the(CALENDER_VIEW, isVisible()));
        actor.attemptsTo(Click.on(CALENDER_VIEW));
        actor.attemptsTo(WaitUntil.the(selectBookingDate(month, day),isVisible()));
        actor.attemptsTo(Click.on(selectBookingDate(month, day)));
    }

    public static void selectQuota(Actor actor, String quota){
        actor.attemptsTo(WaitUntil.the(QUOTA,isVisible()));
        actor.attemptsTo(
                Select.option(quota).from(QUOTA)
        );
    }

    public static void selectClass(Actor actor, String seatClass){
        actor.attemptsTo(WaitUntil.the(SEATCLASS,isVisible()));
        actor.attemptsTo(
                Select.option(seatClass).from(SEATCLASS)
        );
    }

    public static void selectGetTrains(Actor actor){
        actor.attemptsTo(WaitUntil.the(GETTRAINS,isVisible()));
        actor.attemptsTo(Click.on(GETTRAINS));
    }

    public static void writeInExcel(Actor actor) throws IOException {
        List<WebElementFacade> trainListHeading = GETTRAINSLISTHEADINGS.resolveAllFor(actor);
        List<WebElementFacade> trainList = GETTRAINSLIST.resolveAllFor(actor);
        readExcelWorkbook();
        sheet = wb.getSheetAt(0);
        row = sheet.createRow(0);
        for(int i=0; i<trainListHeading.size(); i++){
            row.createCell(i).setCellValue(trainListHeading.get(i).getText());
        }

        for(int j=0; j<trainList.size(); j++){
            HSSFRow dataRow = sheet.createRow(j+1);
            List<WebElement> trainsListDetails = trainList.get(j).findElements(By.tagName("td"));
            for(int k=0; k<trainListHeading.size(); k++){
                String trainDetails = trainsListDetails.get(k).getText();
                if(!trainDetails.contains("Below trains not departing on"))
                    dataRow.createCell(k).setCellValue(trainDetails);
                else{
                    break;
                }
            }
        }
        updateAndCloseExcelWorkbook();
    }

    public static void readExcelWorkbook() throws IOException {
        fis = new FileInputStream(fileName);
        wb = new HSSFWorkbook(fis);
    }

    public static void updateAndCloseExcelWorkbook() throws IOException {
        fos = new FileOutputStream(fileName);
        wb.write(fos);
        fos.close();
        wb.close();
        fis.close();
    }

    public static void selectTrain(Actor actor, int option){
        List<WebElementFacade> trainList = GETTRAINSLIST.resolveAllFor(actor);
        actor.attemptsTo(WaitUntil.the(GETTRAINSLIST, isVisible()));
        actor.attemptsTo(MoveMouse.to(selectTrainFromList(option+1)),
        Click.on(selectTrainFromList(option+1)));
    }

    public static void aboutTrain(Actor actor){
        actor.attemptsTo(WaitUntil.the(TOOLTIPFAREDETAILS, isVisible()));
        String tooltipText = TOOLTIPFAREDETAILS.resolveFor(actor).getText();
        System.out.println("Tooltip Text: " + tooltipText);
    }

    public static void getTrainRoute(Actor actor) throws IOException {
        List<WebElementFacade> trainRouteHeading = TRAINROUTEDETAILSHEADINGS.resolveAllFor(actor);
        List<WebElementFacade> trainRouteDetails = TRAINROUTEDETAILS.resolveAllFor(actor);
        readExcelWorkbook();
        int sheetCount = wb.getNumberOfSheets();
        System.out.println("Sheet Count is: " + sheetCount);
        if(sheetCount<2){
            sheet = wb.createSheet("Train Route");
        }
        else{
            sheet = wb.getSheet("Train Route");
        }
        row = sheet.createRow(0);
        for(int i=0; i< trainRouteHeading.size(); i++){
            row.createCell(i).setCellValue(trainRouteHeading.get(i).getText());
        }

        for(int j=0; j<trainRouteDetails.size(); j++){
            row = sheet.createRow(j+1);
            for(int k=0; k<trainRouteHeading.size(); k++){
               row.createCell(k).setCellValue(getTrainRouteDetails(j+1, k+1).resolveFor(actor).getAttribute("textContent"));
            }
        }
        updateAndCloseExcelWorkbook();
    }

    public static boolean trainAvailabilityStatus(Actor actor){
        return TRAINROUTEDETAILS.resolveFor(actor).isDisplayed();
    }

    public static void downloadTicket(Actor actor){
        actor.attemptsTo(WaitUntil.the(TRAINTICKET, isVisible()));
        actor.attemptsTo(Click.on(TRAINTICKET));
    }
}

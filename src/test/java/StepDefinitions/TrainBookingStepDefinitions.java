package StepDefinitions;

import Pages.TrainBookingPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static HelperMethods.Helper.getActor;

public class TrainBookingStepDefinitions extends UiBase {
    @Given("I navigate to the ERAIL website")
    public void i_navigate_to_the_erail_website() {
        getActor().attemptsTo(new OpenUrl(baseUrl));
    }

    @When("I enter {string} as the source station and selected {int} th entry")
    public void iEnterAsTheSourceStation(String from, int optionFrom) {
        System.out.println("Actor: " + getActor().getName() + " is entering source station: " + from);
        TrainBookingPageObjects.enterFromStation(getActor(),from,optionFrom);
    }

    @And("I enter {string} as the destination station and selected {int} nd entry")
    public void iEnterAsTheDestinationStation(String to, int optionTo) {
        TrainBookingPageObjects.enterToStation(getActor(), to, optionTo);
    }

    @Given("I have searched for trains between {string} and {string}")
    public void i_have_searched_for_trains_between_and(String from, String to) {

    }

    @When("I select the number {int} train from the list")
    public void i_select_the_train_from_the_list(int option) {
        TrainBookingPageObjects.selectTrain(getActor(), option);
    }

    @Then("I should see the train's availability status")
    public void i_should_see_the_train_s_availability_status() {
        boolean status = TrainBookingPageObjects.trainAvailabilityStatus(getActor());
        System.out.println("Train availability status is : " + status);
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String string) {
        TrainBookingPageObjects.aboutTrain(getActor());
    }

    @Then("I should see the timetable for the selected train")
    public void i_should_see_the_timetable_for_the_selected_train() throws IOException {
        TrainBookingPageObjects.getTrainRoute(getActor());
    }

    @When("I download the timetable as a PDF")
    public void i_download_the_timetable_as_a_pdf() {
        TrainBookingPageObjects.downloadTicket(getActor());
    }

    @Then("the PDF should contain the expected timetable information")
    public void the_pdf_should_contain_the_expected_timetable_information() {
        
    }

    @Then("I delete the downloaded PDF file")
    public void i_delete_the_downloaded_pdf_file() {
        
    }

    @When("I enter {string} as booking date")
    public void i_enter_as_booking_date(String date) {
        int day = Integer.parseInt(date.substring(0, date.indexOf('-')));
        String month = date.substring(date.indexOf('-') + 1);
        TrainBookingPageObjects.enterBookingDate(getActor(), month, day);
    }

    @When("I select {string} as Quota")
    public void i_select_as_quota(String quota) {
        TrainBookingPageObjects.selectQuota(getActor(), quota);
    }

    @When("I select {string} as train type")
    public void i_select_as_train_type(String seatClass) {
        TrainBookingPageObjects.selectClass(getActor(),seatClass );
    }

    @Then("I click on {string}")
    public void i_click_on(String string) throws IOException {
        TrainBookingPageObjects.selectGetTrains(getActor());
        TrainBookingPageObjects.writeInExcel(getActor());
    }

    @Given("I have searched for trains between {string} and {string} and selected {int} and {int} entry")
    public void iHaveSearchedForTrainsBetweenAndAndSelectedAndEntry(String from, String to, int optionFrom, int optionTo) {
        TrainBookingPageObjects.enterFromStation(getActor(),from, optionFrom-1);
        TrainBookingPageObjects.enterToStation(getActor(), to, optionTo-1);
    }
}

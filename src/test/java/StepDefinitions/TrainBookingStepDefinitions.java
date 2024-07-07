package StepDefinitions;

import Pages.TrainBookingPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.OpenUrl;

import static HelperMethods.Helper.getActor;

public class TrainBookingStepDefinitions extends UiBase {
    @Given("I navigate to the ERAIL website")
    public void i_navigate_to_the_erail_website() {
        getActor().attemptsTo(new OpenUrl(baseUrl));
    }

    @When("I enter {string} as the source station")
    public void iEnterAsTheSourceStation(String from) {
        TrainBookingPageObjects.enterFromStation(getActor(),from);
    }

    @And("I enter {string} as the destination station")
    public void iEnterAsTheDestinationStation(String to) {
        TrainBookingPageObjects.enterToStation(getActor(), to);
    }

    @Given("I have searched for trains between {string} and {string}")
    public void i_have_searched_for_trains_between_and(String string, String string2) {
        
    }

    @When("I select the first train from the list")
    public void i_select_the_first_train_from_the_list() {
        
    }

    @Then("I should see the train's availability status")
    public void i_should_see_the_train_s_availability_status() {
        
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String string) {
        
    }

    @Then("I should see the timetable for the selected train")
    public void i_should_see_the_timetable_for_the_selected_train() {
        
    }

    @When("I download the timetable as a PDF")
    public void i_download_the_timetable_as_a_pdf() {
        
    }

    @Then("the PDF should contain the expected timetable information")
    public void the_pdf_should_contain_the_expected_timetable_information() {
        
    }

    @Then("I delete the downloaded PDF file")
    public void i_delete_the_downloaded_pdf_file() {
        
    }

    @When("I enter {string} as booking date")
    public void i_enter_as_booking_date(String string) {
        
    }

    @When("I select {string} as Quota")
    public void i_select_as_quota(String string) {
        
    }

    @When("I select {string} as train type")
    public void i_select_as_train_type(String string) {
        
    }

    @Then("I click on {string}")
    public void i_click_on(String string) {
        
    }
}

package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.serenity.RyanairStepsDefinitions;

public class StepDefs {

    @Steps
    RyanairStepsDefinitions client;

    @Given("^That I have enter to Ryanair page$")
    public void thatIHaveEnterToRyanairPage(){
        // Write code here that turns the phrase above into concrete actions
        client.i_have_enter_to_Ryanair_home_page();
    }

    @When("^I search for a \"([^\"]*)\" flight$")
    public void iSearchForAFlight(String type) {
        // Write code here that turns the phrase above into concrete actions
        client.i_search_for_a_flight(type);
    }

    @And("^from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void fromTo(String origin, String destination) {
        // Write code here that turns the phrase above into concrete actions
        client.from_to(origin,destination);
    }
//    @When("^I search for a available flight from \"([^\"]*)\" to \"([^\"]*)\"$")
//    public void iSearchForAAvailableFlightFromTo(String origin, String destination){
//        // Write code here that turns the phrase above into concrete actions
//        client.i_search_for_a_avaible_flight(origin, destination);
//    }
//
//    @And("^is \"([^\"]*)\"$")
//    public void is(String type){
//        // Write code here that turns the phrase above into concrete actions
//
//    }

    @And("^with dates: \"([^\"]*)\" and \"([^\"]*)\"$")
    public void withDatesAnd(String dateOut, String dateBack) {
        // Write code here that turns the phrase above into concrete actions
        client.with_dates(dateOut, dateBack);
    }

    @Then("^I should get (\\d) rows$")
    public void iShouldGetRows(int row){
        client.i_should_get_rows(row);
    }



}

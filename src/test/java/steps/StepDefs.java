package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
    @Given("^That I have enter to Ryanair page$")
    public void thatIHaveEnterToRyanairPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I search for a available flight from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iSearchForAAvailableFlightFromTo(String origin, String destination) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^is \"([^\"]*)\"$")
    public void is(String type) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^with dates: \"([^\"]*)\" and \"([^\"]*)\"$")
    public void withDatesAnd(String date, String dateReturn) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should get (\\d) rows$")
    public void iShouldGetRows(int row) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

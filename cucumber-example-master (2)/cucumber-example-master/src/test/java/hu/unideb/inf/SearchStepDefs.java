package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SearchStepDefs extends AbstractStepDefs {

    @And("the search field is clicked")
    public void theSearchFieldIsClicked() {
        homePage.getSearchField().click();
    }

    @Given("the search bar is filled with {string}")
    public void theSearchBarIsFilledWith(String arg0) {
        homePage.fillField("search_query_top", arg0);
    }

    @When("the search button is clicked")
    public void theSearchButtonIsClicked() {
        homePage.getSearchButton().click();
    }

    @Then("a {string} search error message is shown")
    public void aErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getSearchError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }


}

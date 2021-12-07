package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class BuyStepDefs extends AbstractStepDefs {

    @And("the women's section tab is clicked")
    public void womensSectionButtonIsClicked() {
        homePage.getWomenSectionButton().click();
    }

    @Given("the casual dresses section is clicked")
    public void getCasualDressSectionButtonIsClicked() {
        homePage.getCasualDressSectionButton().click();
    }

    @When("the printed dress is clicked")
    public void getPrintedDressItemButtonIsClicked() {
        homePage.ItemButton().click();
    }

    @When("the add to cart for the printed dress is clicked")
    public void getPrintedDressAddToCartButtonIsClicked() {
        homePage.getPrintedDressAddToCartButton().click();
    }

    @Then("a {string} is shown")
    public void theCartSuccessMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.cartSuccess();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}

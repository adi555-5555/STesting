package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class ForgotPassStepDefs extends AbstractStepDefs {

    @And("the sign in button is clicked for forgot password")
    public void theSignInButtonIsClickedCorr() {
        homePage.getSignInButton3().click();
    }

    @Given("the forgot password button is clicked")
    public void theForgotPasswordButtonIsClicked() {
        homePage.getForgotPasswordButton().click();
    }

    @When("the retrieve password button is clicked without an email")
    public void theRetrievePasswordButton() {
        homePage.getRetrievePasswordButton().click();
    }

    @Then("a {string} for forgot password error is shown")
    public void aErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getForgotPasswordError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }


}

package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SignUpStepDefs extends AbstractStepDefs {

    @And("the sign in button is clicked")
    public void theSignInButtonIsClicked() {
        homePage.getSignInButton().click();
    }

    @Given("the email address field is filled with {string}")
    public void theEmailFieldIsFilledWith(String arg0) {
        homePage.fillField("email_create", arg0);
    }

    @When("the create an account button is clicked")
    public void theCreateAccountButtonIsClicked() {
        homePage.getCreateAccountButton().click();
    }

    @Then("a {string} signup error message is shown")
    public void aErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getSignUpError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }


}

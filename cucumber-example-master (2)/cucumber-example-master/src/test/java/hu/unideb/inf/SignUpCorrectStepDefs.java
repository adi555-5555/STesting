package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SignUpCorrectStepDefs extends AbstractStepDefs {

    @And("the sign in button is clicked for registration")
    public void theSignInButtonIsClickedCorr() {
        homePage.getSignInButton2().click();
    }

    @Given("the email address field is filled with correct email {string}")
    public void theEmailFieldIsFilledWithCorr(String arg0) {
        homePage.fillField("email_create", arg0);
    }

    @When("the create an account button is clicked with correct email")
    public void theCreateAccountButtonIsClickedCorr() {
        homePage.getCreateAccountButton2().click();
    }

    @And("the register button is clicked with the fields empty")
    public void getRegisterButtonClicked() {
        homePage.getRegisterButton().click();
    }

    @Then("a {string} list of errors is shown")
    public void aErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getRegisterError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }


}

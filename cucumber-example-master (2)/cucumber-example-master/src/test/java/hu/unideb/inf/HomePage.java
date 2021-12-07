package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final String PAGE_URL = "http://automationpractice.com/";

    private static final By LOGIN_ERROR = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    private static final By CONTACT_ERROR = By.cssSelector("#center_column > div > ol > li");
    private static final By CART_SUCCESS = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2");
    private static final By SEARCH_ERROR = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/p");
    private static final By SIGNUP_ERROR = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]/ol/li");
    private static final By REGISTER_ERROR = By.xpath("//*[@id=\"center_column\"]/div/p");
    private static final By FORGOTPW_ERROR = By.xpath("//*[@id=\"center_column\"]/div/div/ol");

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton1;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton2;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton3;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    private WebElement forgotPasswordButton;

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy( xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    private WebElement womenSectionButton;

    @FindBy( xpath = "//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a")
    private WebElement casualDressesSectionButton;

    @FindBy( xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a")
    private WebElement ItemButton;

    @FindBy( xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div/p/button/span")
    private WebElement printedDressAddToCartButton;

    @FindBy( xpath = "//*[@id=\"search_query_top\"]")
    private WebElement searchField;

    @FindBy( xpath = "//*[@id=\"searchbox\"]/button")
    private WebElement searchButton;

    @FindBy( xpath = "//*[@id=\"SubmitCreate\"]")
    private WebElement createAccountButton;

    @FindBy( xpath = "//*[@id=\"SubmitCreate\"]")
    private WebElement createAccountButton2;

    @FindBy( xpath = "//*[@id=\"submitAccount\"]")
    private WebElement registerButton;

    @FindBy( xpath = "//*[@id=\"form_forgotpassword\"]/fieldset/p/button")
    private WebElement retrievePasswordButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public Optional<String> getLoginError() {
        return getErrorMessage(LOGIN_ERROR);
    }

    public Optional<String> getSearchError() {
        return getErrorMessage(SEARCH_ERROR);
    }

    public Optional<String> getContactError() {
        return getErrorMessage(CONTACT_ERROR);
    }

    public Optional<String> cartSuccess() {
        return getErrorMessage(CART_SUCCESS);
    }

    public Optional<String> getSignUpError() {
        return getErrorMessage(SIGNUP_ERROR);
    }

    public Optional<String> getRegisterError() {
        return getErrorMessage(REGISTER_ERROR);
    }

    public Optional<String> getForgotPasswordError() {
        return getErrorMessage(FORGOTPW_ERROR);
    }

    public void fillField(String field, String value) {
        getField(By.id(field)).sendKeys(value);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getSignInButton() {
        return signInButton1;
    }

    public WebElement getSignInButton2() {
        return signInButton2;
    }

    public WebElement getSignInButton3() {
        return signInButton3;
    }

    public WebElement getContactUsLink() {
        return contactUsLink;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public WebElement getWomenSectionButton(){return womenSectionButton; }

    public WebElement getCasualDressSectionButton(){return casualDressesSectionButton; }

    public WebElement ItemButton(){return ItemButton; }

    public WebElement getPrintedDressAddToCartButton(){return printedDressAddToCartButton;}

    public WebElement getSearchField(){return searchField;}

    public WebElement getSearchButton(){return searchButton;}

    public WebElement getCreateAccountButton(){return createAccountButton;}

    public WebElement getCreateAccountButton2(){return createAccountButton2;}

    public WebElement getRegisterButton(){return registerButton;}

    public WebElement getForgotPasswordButton(){return forgotPasswordButton;}

    public WebElement getRetrievePasswordButton(){return retrievePasswordButton;}



        private Optional<String> getErrorMessage(By errorLocator) {
        Optional<WebElement> error = getError(errorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getError(By errorLocator) {
        List<WebElement> elements = driver.findElements(errorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }
}

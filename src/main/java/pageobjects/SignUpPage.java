package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjectmanager.PageObjectManager;

import java.time.Duration;

public class SignUpPage extends PageObjectManager {

    @FindBy(xpath = "//h1[normalize-space()='Sign up to JDoodle']")
    private WebElement signUpPageTitle;

    @FindBy(xpath = "//input[@id='Email AddressjoeDoe@example.com']")
    private WebElement emailIdInputField;

    @FindBy(xpath = "//input[@id='Display NameJoe']")
    private WebElement nameInputField;

    @FindBy(xpath = "//input[@id='register_pwd']")
    private WebElement pwdInputField;

    @FindBy(xpath = "//input[@id='Confirm Password*****']")
    private WebElement confirmPwdInputField;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    private WebElement confirmCaptchaBox;

    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Sign Up']")
    private WebElement confirmSignUpBtn;
    @FindBy(xpath = " (//p[@class='text-md mb-5'])")
    private WebElement registrationTxt;

    @FindBy(xpath = "//p[@class='text-sm success']")
    private WebElement confirmationEmailTxt;

    @FindBy(xpath = "(//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')])[2]")
    private WebElement iframeCaptcha;

    @FindBy(xpath = "//p[@class='p-xsmall error']")
    private WebElement alreadyRegisteredErrorTxt;

    private final WebDriverWait wait;

    public SignUpPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean waitForSignUpPageLoad(){
        return wait.until(driver -> signUpPageTitle.isDisplayed());
    }

    public boolean waitForSignUpBtnEnabled(){
        return wait.until(driver -> confirmSignUpBtn.isEnabled());
    }

    public void submitNewUserDetailsForSignUp(String emailId, String name, String pwd){
        getLoginPage().getSignUpBtn().click();
        waitForSignUpPageLoad();
        emailIdInputField.sendKeys(emailId);
        nameInputField.sendKeys(name);
        pwdInputField.sendKeys(pwd);
        confirmPwdInputField.sendKeys(pwd);
        driver.switchTo().frame(iframeCaptcha);
        confirmCaptchaBox.click();
        driver.switchTo().defaultContent();
        waitForSignUpBtnEnabled();
        confirmSignUpBtn.click();
    }

    public boolean verifyRegistrationText(){
        return registrationTxt.getText().equals("Thanks for registering to JDoodle.");
    }

    public boolean verifyConfirmationEmailTxt(){
        return registrationTxt.getText().equals("We have sent you a confirmation email. Before logging in, please check your email to complete registration.");
    }

    public boolean verifyAlreadyRegisteredText(){
        return alreadyRegisteredErrorTxt.getText().equals("This email is already registered");
    }

}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjectmanager.PageObjectManager;

import java.time.Duration;

public class LoginPage extends PageObjectManager {

    @FindBy(xpath = "//button[@type='button'][normalize-space()='Sign Up']")
    private WebElement signUpBtn;

    private final WebDriverWait wait;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean waitForLoginPageLoad(){
        return wait.until(driver -> signUpBtn.isDisplayed());
    }
    public boolean isSignUpOptionEnabled(){
        waitForLoginPageLoad();
        return signUpBtn.isEnabled();
    }

    public WebElement getSignUpBtn(){
        return signUpBtn;
    }
}

package pageobjectmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignUpPage;

public class PageObjectManager {

    protected WebDriver driver;

    private HomePage homePage;
    private SignUpPage signUpPage;

    private LoginPage loginPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return homePage = PageFactory.initElements(driver,HomePage.class);
    }

    public SignUpPage getSignUpPage() {
        return signUpPage = PageFactory.initElements(driver,SignUpPage.class);
    }

    public LoginPage getLoginPage() {
        return loginPage = PageFactory.initElements(driver,LoginPage.class);
    }
}

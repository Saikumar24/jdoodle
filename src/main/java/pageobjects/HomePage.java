package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjectmanager.PageObjectManager;

import java.time.Duration;

public class HomePage extends PageObjectManager {

    @FindBy(xpath = "(//img[@alt='JDoodle'])[20]")
    private WebElement jDoodleLogo;

    @FindBy(xpath = "(//div[@class='text-primary flex items-center gap-2 md:text-sm text-[14px]'])[1]")
    private WebElement loginBtn;

    @FindBy(xpath = "//button[normalize-space()='Execute']")
    private WebElement executeBtn;

    @FindBy(xpath = "//div[@id='output']//div[@class='ace_content']")
    private WebElement outputScreen;

    @FindBy(xpath = "//div[@id='code']//div[@class='ace_content']")
    private WebElement editorScreen;

    private final WebDriverWait wait;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public boolean waitForHomePageLoad() {
        return wait.until(driver -> jDoodleLogo.isDisplayed());
    }

    public void launchJdoodleWebsite(){
        driver.get("https://www.jdoodle.com/online-java-compiler");
        driver.manage().window().maximize();
    }

    public boolean isLoginBtnEnabled(){
        waitForHomePageLoad();
        return loginBtn.isEnabled();
    }

    public void clickLoginBtn(){
      loginBtn.click();
    }

    public void clickExecuteBtn(){
        executeBtn.click();
    }

    public boolean verifyOutputTxt() {
        return wait.until(ExpectedConditions.textToBePresentInElement(outputScreen,"Sum of x+y = 35"));
    }

    public void clearExistingCode(){
        driver.navigate().refresh();
        isLoginBtnEnabled();
        wait.until(ExpectedConditions.elementToBeClickable(editorScreen));
        editorScreen.click();
        editorScreen.clear();
    }

    public void addTextInEditor(){
        wait.until(ExpectedConditions.elementToBeClickable(editorScreen));
        editorScreen.click();
        editorScreen.sendKeys("This is the sample text");
    }



    public String getTextInEditor(){
        wait.until(ExpectedConditions.elementToBeClickable(editorScreen));
        return editorScreen.getText();
    }

    public void scrollToEditor() {
        js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
    }
}

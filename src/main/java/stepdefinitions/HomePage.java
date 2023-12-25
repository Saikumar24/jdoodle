package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import testcontext.Context;

public class HomePage extends BaseTest {


    public HomePage(Context context) {
        super(context);
    }

    @Given("User launches the jdoodle application")
    public void userLaunchesTheJdoodleApplication(){
        testContext.getPageObjectManager().getHomePage().launchJdoodleWebsite();
    }

    @And("User is able to view the homepage of the application")
    public void userIsAbleToViewTheHomepageOfTheApplication() {
        Assert.assertTrue(testContext.getPageObjectManager().getHomePage().waitForHomePageLoad());
    }

    @And("User is able to view the login button")
    public void userIsAbleToViewTheLoginButton() {
        Assert.assertTrue(testContext.getPageObjectManager().getHomePage().isLoginBtnEnabled());
    }

    @When("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        testContext.getPageObjectManager().getHomePage().clickLoginBtn();
    }

    @And("User clicks on execute button")
    public void userClicksOnExecuteButton() {
        testContext.getPageObjectManager().getHomePage().clickExecuteBtn();
    }

    @And("User is able to see the correct response in the output screen")
    public void userIsAbleToSeeTheCorrectResponseInTheOutputScreen() {
        Assert.assertTrue(testContext.getPageObjectManager().getHomePage().verifyOutputTxt());
    }

    @And("User is able to add text into the editor screen")
    public void userIsAbleToAddTextIntoTheEditorScreen() {
        testContext.getPageObjectManager().getHomePage().clearExistingCode();
        testContext.getPageObjectManager().getHomePage().addTextInEditor();
        Assert.assertTrue(testContext.getPageObjectManager().getHomePage().getTextInEditor().contentEquals("This is the sample text"));
    }

    @And("User scrolls up to the editor screen")
    public void userScrollsUpToTheEditorScreen() {
        testContext.getPageObjectManager().getHomePage().scrollToEditor();
    }
}

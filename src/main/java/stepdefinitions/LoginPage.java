package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import testcontext.Context;

public class LoginPage extends BaseTest{

    public LoginPage(Context context) {
        super(context);
    }

    @Then("User is shown with the signup option")
    public void userIsShownWithTheSignupOption() {
        Assert.assertTrue(testContext.getPageObjectManager().getLoginPage().isSignUpOptionEnabled());
    }
}

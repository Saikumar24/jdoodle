package stepdefinitions;

import io.cucumber.java.en.And;
import org.testng.Assert;
import testcontext.Context;

public class SignUpPage extends BaseTest{

    public SignUpPage(Context context) {
        super(context);
    }

    @And("User fills in the {string},{string},{string} in the signup page")
    public void userFillsInTheInTheSignupPage(String emailId, String name, String pwd) {
        testContext.getPageObjectManager().getSignUpPage().submitNewUserDetailsForSignUp(emailId,name,pwd);
    }


    @And("User completes the signup process")
    public void userCompletesTheSignupProcess() {
        Assert.assertTrue(testContext.getPageObjectManager().getSignUpPage().waitForSignUpPageLoad());
        Assert.assertTrue(testContext.getPageObjectManager().getSignUpPage().verifyRegistrationText());
        Assert.assertTrue(testContext.getPageObjectManager().getSignUpPage().verifyConfirmationEmailTxt());
    }

    @And("User is thrown with already registered email error message")
    public void userIsThrownWithAlreadyRegisteredEmailErrorMessage() {
        Assert.assertTrue(testContext.getPageObjectManager().getSignUpPage().verifyAlreadyRegisteredText());
    }
}

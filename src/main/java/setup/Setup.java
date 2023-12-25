package setup;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import testcontext.Context;
import webdriverinstance.WebDriverInstance;

public class Setup {

    private Context context;

    @BeforeSuite
    public void setUp(){
        initPage();
    }

    private void initPage(){
        this.context = new Context();
    }

    @AfterSuite
    public void tearDown() {
        WebDriverInstance.getInstance().quitDriver();
    }

}

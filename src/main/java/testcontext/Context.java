package testcontext;

import pageobjectmanager.PageObjectManager;
import webdriverinstance.WebDriverInstance;

public class Context {

    private final PageObjectManager pageObjectManager;

    public Context() {
        pageObjectManager = new PageObjectManager(WebDriverInstance.getInstance().getWebDriver());
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}

package webdriverinstance;

import filepath.FilePath;
import filereader.PropertyFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static logger.LoggingManager.logger;

public class WebDriverInstance {

    private static WebDriverInstance instance = null;

    private WebDriver driver;

    private String browser;

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return this.browser;
    }

    public static WebDriverInstance getInstance() {
        if ((instance == null)) {
            instance = new WebDriverInstance();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        if (driver == null) {
            initialize();
            driver = setupWebDriver();
        }
        return driver;
    }

    private void initialize() {
        PropertyFileReader handler = new PropertyFileReader(FilePath.getConfigPath() + "config.properties");
        setBrowser(handler.getProperty("BROWSER"));
    }

    public WebDriver setupWebDriver() {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser specified");
                break;
        }
        return driver;
    }

    public void quitDriver() {
        try {
            driver.quit();
            instance = null;
        } catch (Exception e) {
            logger.error(e);
        }
    }
}

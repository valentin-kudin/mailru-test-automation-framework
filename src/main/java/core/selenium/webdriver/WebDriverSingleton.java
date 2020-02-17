package core.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {

    }

    public static WebDriver getWebDriver(DriverType type) {
        switch (type) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver",
                        "src/main/resources/webdrivers/chromedriver");
                if (driver == null) {
                    driver = new ChromeDriver();
                }
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver",
                        "src/main/resources/webdrivers/geckodriver");
                if (driver == null) {
                    driver = new FirefoxDriver();
                }
                break;
            case SAFARI:
                System.setProperty("webdriver.safari.driver",
                        "/usr/bin/safaridriver");
                if (driver == null) {
                    driver = new SafariDriver();
                }
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}


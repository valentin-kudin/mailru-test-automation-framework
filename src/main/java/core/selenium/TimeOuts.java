package core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOuts {

    private WebDriver driver;

    private final int CLICKABLE_TIME = 15;
    private final int VISIBLE_TIME = 15;
    private final int PRESENTABLE_TIME = 15;

    public TimeOuts(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitUntilClickable(WebElement webElement, int time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitUntilVisible(WebElement webElement, int time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitUntilPresentable(String xpath, int time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public int getCLICKABLE_TIME() {
        return CLICKABLE_TIME;
    }

    public int getVISIBLE_TIME() {
        return VISIBLE_TIME;
    }

    public int getPRESENTABLE_TIME() {
        return PRESENTABLE_TIME;
    }
}

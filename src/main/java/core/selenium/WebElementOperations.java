package core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElementOperations {

    private WebDriver driver;
    private Actions actions;

    public WebElementOperations(WebDriver driver) {
       this.driver = driver;
       actions = new Actions(driver);
    }

    public WebElement getWebElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void rightClickMouse(WebElement webElement) {
        actions.contextClick(webElement).perform();
    }
}

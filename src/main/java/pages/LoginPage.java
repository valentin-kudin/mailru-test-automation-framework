package pages;

import core.selenium.TimeOuts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private TimeOuts timeOuts;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = ".//div[@class='nav__folder nav__folder_parent']")
    private WebElement inboxButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        timeOuts = new TimeOuts(driver);
    }

    public void enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
        buttonEnter.click();
    }

    public void enterPassword(String password) {
        timeOuts.waitUntilClickable(passwordField, timeOuts.getCLICKABLE_TIME()).clear();
        passwordField.sendKeys(password);
        buttonEnter.click();
    }

    public boolean isInboxButtonVisible() {
        return timeOuts.waitUntilVisible(inboxButton, timeOuts.getVISIBLE_TIME()).isDisplayed();
    }
}

package pages;

import core.selenium.TimeOuts;
import core.selenium.WebElementOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendLetterPage {

    private TimeOuts timeOuts;
    private WebElementOperations elementOperations;

    @FindBy(xpath = "(.//span[contains(@class,'compose-button')])[1]")
    private WebElement composeLetterButton;

    @FindBy(xpath = ".//div[@class='contacts--1ofjA']//input")
    private WebElement addresseeField;

    @FindBy(xpath = ".//div[@class='subject__wrapper--2mk6m']//input")
    private WebElement subjectField;

    @FindBy(xpath = ".//div[contains(@class,'editable-container')]//following::div[1]")
    private WebElement messageTextField;

    @FindBy(xpath = ".//span[@class='button2 button2_base button2_primary button2_hover-support js-shortcut']")
    private WebElement sendButton;

    @FindBy(xpath = ".//div[@class='layer__header']")
    private WebElement sentMessageNotification;

    @FindBy(xpath = ".//span[@data-title-shortcut='Cmd+S']")
    private WebElement saveButton;

    @FindBy(xpath = ".//button[@tabindex='700']")
    private WebElement closeLetterCreationWindowButton;

    @FindBy(xpath = ".//span[@tabindex='1000']")
    private WebElement closeSendingLetterConfirmationWindowButton;


    public SendLetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        timeOuts = new TimeOuts(driver);
        elementOperations = new WebElementOperations(driver);
    }

    public void clickComposeLetterButton() {
        timeOuts.waitUntilClickable(composeLetterButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void enterAddressee(String addressee) {
        timeOuts.waitUntilClickable(addresseeField, timeOuts.getCLICKABLE_TIME()).sendKeys(addressee);
    }

    public void enterSubject(String subject) {
        timeOuts.waitUntilClickable(subjectField, timeOuts.getCLICKABLE_TIME()).sendKeys(subject);
    }

    public void enterMessage(String message) {
        timeOuts.waitUntilClickable(messageTextField, timeOuts.getCLICKABLE_TIME()).sendKeys(message);
    }


    public void sendLetter() {
        sendButton.click();
    }

    public boolean isSentMessageNotificationVisible() {
        return timeOuts.waitUntilVisible(sentMessageNotification, timeOuts.getVISIBLE_TIME()).isDisplayed();
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void closeLetterCreationWindow() {
        timeOuts.waitUntilClickable(closeLetterCreationWindowButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void closeCloseSendingLetterConfirmationWindowButton() {
        timeOuts.waitUntilClickable(closeSendingLetterConfirmationWindowButton, timeOuts.getCLICKABLE_TIME()).click();
    }




}

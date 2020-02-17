package pages;

import core.selenium.TimeOuts;
import core.selenium.WebElementOperations;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {

    private TimeOuts timeOuts;
    private WebElementOperations elementOperations;

    @FindBy(xpath = "(.//button[contains(@class,'ll-av ll-av_size_common')])[1]")
    private WebElement firstLetterCheckbox;

    @FindBy(xpath = ".//div[contains(@class,'portal-menu-element portal-menu-element_spam')]")
    private WebElement sendToSpamButton;
    @FindBy(xpath = ".//div[contains(@class,'portal-menu-element portal-menu-element_move')]")
    private WebElement moveToFolderButton;

    @FindBy(xpath = ".//div[@class='octopus__icon octopus__icon_spam']")
    private WebElement fingerUpIcon;

    @FindBy(xpath = ".//span[@class='notify__message']")
    private WebElement movedToInboxNotification;

    @FindBy(xpath = ".//span[@class='notify__message__text']")
    private WebElement movedToSpamNotification;

    @FindBy(xpath = ".//span[@class='notify__message__text']")
    private WebElement notification;

    @FindBy(xpath = ".//a[@href='/spam/']")
    private WebElement spamButton;

    @FindBy(xpath = ".//a[@href='/drafts/']")
    private WebElement draftsButton;

    @FindBy(xpath = ".//a[@href='/trash/']")
    private WebElement trashButton;

    @FindBy(xpath = ".//a[@href='/inbox/']")
    private WebElement inboxButton;

    @FindBy(xpath = "(.//div[@class='list-item list-item_hover-support'])[1]")
    private WebElement inboxHoverButton;

    @FindBy(xpath = "(.//a[contains(@class,'llc js-tooltip-direction_letter-bottom js-letter-list-item llc_normal')])" +
            "[1]//button[contains(@class,'ll-fs')]")
    private WebElement firstLetterFlag;

    @FindBy(xpath = "(.//a[contains(@class,'llc js-tooltip-direction_letter-bottom js-letter-list-item llc_normal')])" +
            "[3]//button[contains(@class,'active')]")
    private WebElement thirdLetterFlagActive;

    @FindBy(xpath = ".//div[contains(@class,'portal-menu-element portal-menu-element_select portal-menu-element')]")
    private WebElement selectAllButton;

    @FindBy(xpath = ".//span[@class='button2 button2_has-ico button2_select-all button2_pure button2_ico-text-top " +
            "button2_hover-support js-shortcut']")
    private WebElement unselectAllButton;

    @FindBy(xpath = ".//div[@class='dropdown-actions']")
    private WebElement moreOptionsThreeDots;

    @FindBy(xpath = ".//span[@class='list-item__ico list-item__ico_unflag']")
    private WebElement unflagSelectedLettersButton;

    @FindBy(xpath = ".//div[@class='notify-stack notify-stack_fixed']//span[@class='notify__message__text']")
    private WebElement unflagNotify;

    @FindBy(xpath = ".//div[@class='list-letter-tip__controls']//a[@rel='noopener noreferer']")
    private WebElement clearFolderButton;

    @FindBy(xpath = ".//div[@data-qa-id='new-folder-btn']")
    private WebElement newFolderButton;

    @FindBy(xpath = ".//input[@name='name']")
    private WebElement folderNameField;

    @FindBy(xpath = ".//button[@data-test-id='submit']")
    private WebElement createFolderButton;

    @FindBy(xpath = ".//div[text()='TestDDD']")
    private WebElement testFolder;

    @FindBy(xpath = ".//div[@data-qa-id='delete']")
    private WebElement deleteFolderContextButton;

    @FindBy(xpath = ".//span[@class='button2 button2_base button2_primary button2_fluid button2_hover-support']")
    private WebElement confirmationDeleteButton;

    @FindBy(xpath = ".//span[contains(@class,'button2 button2_has-ico button2_delete button2')]")
    private WebElement deleteButton;

    @FindBy(xpath = ".//span[text()='testDDD']")
    private WebElement testLetter;


    public InboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        timeOuts = new TimeOuts(driver);
        elementOperations = new WebElementOperations(driver);
    }

    public void selectFirstLetter() {
        timeOuts.waitUntilClickable(firstLetterCheckbox, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void clickMoveToSpamButton() {
        timeOuts.waitUntilClickable(sendToSpamButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void clickMoveToFolderButton() {
        timeOuts.waitUntilClickable(moveToFolderButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void clickMoveToInboxHoverButton() {
        timeOuts.waitUntilClickable(inboxHoverButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void goToInbox() {
        timeOuts.waitUntilClickable(inboxButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void goToSpam() {
        timeOuts.waitUntilClickable(spamButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void goToTrash() {
        timeOuts.waitUntilClickable(trashButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void goToDrafts() {
        timeOuts.waitUntilClickable(draftsButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public boolean isMovedToSpamNotificationVisible() {
        return timeOuts.waitUntilVisible(movedToSpamNotification, timeOuts.getVISIBLE_TIME()).isDisplayed();
    }

    public boolean isMovedToInboxNotificationVisible() {
        return timeOuts.waitUntilVisible(movedToInboxNotification, timeOuts.getVISIBLE_TIME()).isDisplayed();
    }

    public void waitForClearFolderButton() {
        timeOuts.waitUntilClickable(clearFolderButton, timeOuts.getCLICKABLE_TIME());
    }

    public void toFlagLetters(int numberOfLettersToFlag) {
        timeOuts.waitUntilClickable(firstLetterFlag, timeOuts.getCLICKABLE_TIME());
        for (int i = 1; i <= numberOfLettersToFlag; i++) {
            elementOperations.getWebElementByXpath("(.//a[contains(@class,'llc js-tooltip-direction_letter-bottom " +
                    "js-letter-list-item llc_normal')])[" + i + "]//button[contains(@class,'ll-fs')]").click();
        }
    }

    public void clickMoreOptionsThreeDots() {
        moreOptionsThreeDots.click();
    }

    public void clickUnflagSelectedLettersButton() {
        timeOuts.waitUntilClickable(unflagSelectedLettersButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void clickSelectAllButton() {
        timeOuts.waitUntilVisible(thirdLetterFlagActive, timeOuts.getVISIBLE_TIME());
        selectAllButton.click();
    }


    public boolean areLettersFlagged(int numberOfLetters) {
        int booleanCounter = 0;

        for (int i = 1; i <= numberOfLetters; i++) {
            if (timeOuts.waitUntilVisible(elementOperations.getWebElementByXpath(
                    "(.//a[contains(@class,'llc js-tooltip-direction_letter-bottom " +
                    "js-letter-list-item llc_normal')])[" + i + "]//button[contains(@class,'active')]"),
                    timeOuts.getVISIBLE_TIME())
                    .isDisplayed()) {
                booleanCounter++;
            }
        }
        return booleanCounter == numberOfLetters;
    }

    public boolean areAllLettersUnflagged() {
        return timeOuts.waitUntilVisible(notification, timeOuts.getVISIBLE_TIME()).isDisplayed();
    }

    public void clickNewFolderButton() {
        timeOuts.waitUntilClickable(newFolderButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void enterFolderName(String folderName) {
        timeOuts.waitUntilClickable(folderNameField, timeOuts.getCLICKABLE_TIME()).sendKeys(folderName);

    }

    public void clickCreateFolderButton() {
        createFolderButton.click();
    }

    public boolean isTestFolderVisible() {
        boolean marker = true;
        try {
            timeOuts.waitUntilVisible(testFolder, 5);
        } catch (TimeoutException exception) {
            marker = false;
            System.out.println("");
        }

        return marker && testFolder.isDisplayed();
    }

    public void rightClickOnFolder() {
        timeOuts.waitUntilClickable(testFolder, timeOuts.getCLICKABLE_TIME());
        elementOperations.rightClickMouse(testFolder);
    }

    public void clickDeleteFolderContextButton() {
        timeOuts.waitUntilClickable(deleteFolderContextButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void clickConfirmationDeleteButton() {
        timeOuts.waitUntilClickable(confirmationDeleteButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public void clickDeleteButton() {
        timeOuts.waitUntilClickable(deleteButton, timeOuts.getCLICKABLE_TIME()).click();
    }

    public boolean isNotificationVisible() {
        return timeOuts.waitUntilVisible(notification, timeOuts.getVISIBLE_TIME()).isDisplayed();
    }

    public boolean isTestLetterVisible() {
        return timeOuts.waitUntilVisible(testLetter, timeOuts.getVISIBLE_TIME()).isDisplayed();
    }

    public void waitForInbox() {
        timeOuts.waitUntilClickable(inboxButton, timeOuts.getCLICKABLE_TIME());
    }
}

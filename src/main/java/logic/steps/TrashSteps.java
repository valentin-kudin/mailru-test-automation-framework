package logic.steps;

import core.logfourj.LoggerInitializing;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.InboxPage;

public class TrashSteps extends BaseSteps {

    private WebDriver driver;
    private InboxPage inboxPage;

    public TrashSteps() {
        driver = getDriver();
        inboxPage = new InboxPage(driver);
        logger = LoggerInitializing.getLogger(this.getClass());
    }

    @Given("^I am on inbox page$")
    public void loadInboxPage() {
        loadMainPage(driver);
        toLoginValidly(driver);
        logger.info("Login");
    }

    @Given("^I am on trash page$")
    public void loadTrashPage() {
        loadMainPage(driver);
        toLoginValidly(driver);
        logger.info("Login");
        inboxPage.goToTrash();
        logger.info("Go to trash");
    }

    @When("^I move letter to trash$")
    public void moveLetterToTrash() {
        inboxPage.goToInbox();
        inboxPage.selectFirstLetter();
        inboxPage.clickDeleteButton();
        logger.info("Delete one letter");
    }

    @When("^I move letter from trash to inbox$")
    public void moveLetterFromTrash() {
        inboxPage.waitForClearFolderButton();
        inboxPage.selectFirstLetter();
        inboxPage.clickMoveToFolderButton();
        inboxPage.clickMoveToInboxHoverButton();
        logger.info("Move one letter from trash to inbox");
    }

    @Then("I see notification of moving letter to trash")
    public void seeNotificationOfMovingToTrash() {
        Assert.assertTrue(inboxPage.isNotificationVisible());
    }

    @Then("I see notification of moving letter from trash to inbox")
    public void seeNotificationOfMovingLetterFromTrashToInbox() {
        Assert.assertTrue(inboxPage.isNotificationVisible());
    }

    @After("@Trash")
    public void afterClass() {
        driver.quit();
    }
}

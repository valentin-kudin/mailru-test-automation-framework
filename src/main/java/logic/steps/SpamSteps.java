package logic.steps;

import core.logfourj.LoggerInitializing;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.InboxPage;

public class SpamSteps extends BaseSteps {

    private WebDriver driver;
    private InboxPage inboxPage;

    public SpamSteps() {
        driver = getDriver();
        inboxPage = new InboxPage(driver);
        logger = LoggerInitializing.getLogger(this.getClass());
    }

    @Given("^I am on the inbox page$")
    public void loadInboxPage() {
        loadMainPage(driver);
        toLoginValidly(driver);
        logger.info("Login");
    }

    @Given("^I am on spam page$")
    public void loadSpamPage() {
        loadMainPage(driver);
        toLoginValidly(driver);
        logger.info("Login");
        inboxPage.goToSpam();
        logger.info("Go to spam");
    }

    @When("^I move letter to spam$")
    public void moveLetterToSpam() {
        inboxPage.goToInbox();
        inboxPage.selectFirstLetter();
        inboxPage.clickMoveToSpamButton();
        logger.info("Move one letter to spam");
    }

    @When("^I move letter from spam to inbox$")
    public void moveLetterFromSpam() {
        inboxPage.waitForClearFolderButton();
        inboxPage.selectFirstLetter();
        inboxPage.clickMoveToFolderButton();
        inboxPage.clickMoveToInboxHoverButton();
        logger.info("Move one letter to inbox");
    }

    @Then("I see notification of moving letter to spam")
    public void seeNotificationOfMovingToSpam() {
        Assert.assertTrue(inboxPage.isMovedToSpamNotificationVisible());
    }

    @Then("I see notification of moving letter from spam to inbox")
    public void seeNotificationOfMovingLetterFromSpamToInbox() {
        Assert.assertTrue(inboxPage.isMovedToInboxNotificationVisible());
    }

    @After("@Spam")
    public void afterClass() {
        driver.quit();
    }
}

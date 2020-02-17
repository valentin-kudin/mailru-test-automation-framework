package logic.steps;

import core.logfourj.LoggerInitializing;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.InboxPage;
import pages.LoginPage;

public class FlagLettersSteps extends BaseSteps {

    private InboxPage inboxPage;
    private LoginPage loginPage;
    private WebDriver driver;

    public FlagLettersSteps() {
        driver = getDriver();
        inboxPage = new InboxPage(driver);
        loginPage = new LoginPage(driver);
        logger = LoggerInitializing.getLogger(this.getClass());
    }

    @Given("^I am on inbox$")
    public void loadInboxPage() {
        loadMainPage(driver);
        toLoginValidly(driver);
        logger.info("Login");
    }

    @When("^I flag first three letters$")
    public void flagThreeLetters() {
        inboxPage.goToInbox();
        inboxPage.toFlagLetters(numberOfFlags);
        logger.info(numberOfFlags + " letters are flagged.");
    }

    @When("^I unflag first three letters$")
    public void unflagThreeLetters() {
        inboxPage.clickSelectAllButton();
        inboxPage.clickMoreOptionsThreeDots();
        inboxPage.clickUnflagSelectedLettersButton();
        logger.info("Unflag all letters");
    }

    @Then("^I see first three letters flagged$")
    public void seeFirstThreeLettersFlagged() {
        Assert.assertTrue(inboxPage.areLettersFlagged(numberOfFlags));
    }

    @Then("^I see first three letters unflagged$")
    public void seeFirstThreeLettersUnflagged() {
        Assert.assertTrue(inboxPage.areAllLettersUnflagged());
    }

    @After("@Flag")
    public void afterClass() {
        driver.quit();
    }
}

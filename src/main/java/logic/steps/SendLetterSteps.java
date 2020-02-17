package logic.steps;

import core.logfourj.LoggerInitializing;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SendLetterPage;

public class SendLetterSteps extends BaseSteps {

    private WebDriver driver;
    private SendLetterPage sendLetterPage;

    public SendLetterSteps() {
        driver = getDriver();
        sendLetterPage = new SendLetterPage(driver);
        logger = LoggerInitializing.getLogger(this.getClass());
    }

    @Given("^I am on page inbox$")
    public void loadInboxPage() {
        loadMainPage(driver);
        toLoginValidly(driver);
        logger.info("Login");
    }

    @When("^I go to letter creation window$")
    public void openLetterCreationWindow() {
        sendLetterPage.clickComposeLetterButton();
        logger.info("Open letter creation window");
    }

    @And("^I fill in fields$")
    public void fillInFields() {
        sendLetterPage.enterAddressee(addressee);
        sendLetterPage.enterSubject(subject);
        sendLetterPage.enterMessage(message);
        logger.info("Fill in letter fields");
    }

    @And("^I send letter$")
    public void sendLetter() {
        sendLetterPage.sendLetter();
        logger.info("Send letter");
    }

    @Then("I see notification that letter was sent successfully")
    public void seeSentSuccessfullyNotification() {
        Assert.assertTrue(sendLetterPage.isSentMessageNotificationVisible());
    }

    @After("@Sendletter")
    public void afterClass() {
        driver.quit();
    }
}

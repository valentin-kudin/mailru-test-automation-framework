package logic;

import core.logfourj.LoggerInitializing;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.InboxPage;
import pages.SendLetterPage;

public class DraftLogic {

    private InboxPage inboxPage;
    private SendLetterPage sendLetterPage;
    private Logger logger = LoggerInitializing.getLogger(this.getClass());

    public DraftLogic(WebDriver driver) {
        inboxPage = new InboxPage(driver);
        sendLetterPage = new SendLetterPage(driver);
    }

    public void createLetterForDrafts(String subject) {
        sendLetterPage.clickComposeLetterButton();
        sendLetterPage.enterSubject(subject);
        logger.info("Create letter for drafts");
    }

    public void saveLetterToDrafts() {
        sendLetterPage.clickSaveButton();
        logger.info("Save letter");
    }

    public boolean isSavingLetterToDraftsSuccessful() {
        return inboxPage.isNotificationVisible();
    }

    public boolean isThereSpecificLetterInDrafts() {
        inboxPage.goToDrafts();
        return inboxPage.isTestLetterVisible();
    }
}

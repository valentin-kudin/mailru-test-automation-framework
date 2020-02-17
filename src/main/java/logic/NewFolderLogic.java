package logic;

import core.logfourj.LoggerInitializing;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.InboxPage;

public class NewFolderLogic {

    private InboxPage inboxPage;
    private Logger logger = LoggerInitializing.getLogger(this.getClass());

    public NewFolderLogic(WebDriver driver) {
        inboxPage = new InboxPage(driver);
    }

    public void createNewFolder() {
        inboxPage.clickNewFolderButton();
        inboxPage.enterFolderName("TestDDD");
        inboxPage.clickCreateFolderButton();
        logger.info("Create new folder");
    }

    public void deleteFolder() {
        inboxPage.rightClickOnFolder();
        inboxPage.clickDeleteFolderContextButton();
        inboxPage.clickConfirmationDeleteButton();
        logger.info("Delete folder");
    }

    public boolean isFolderVisible() {
        return inboxPage.isTestFolderVisible();
    }
}

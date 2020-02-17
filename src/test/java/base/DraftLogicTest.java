package base;

import logic.DraftLogic;
import logic.LoginLogic;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DraftLogicTest extends BaseTest {

    private WebDriver driver;
    private LoginLogic loginLogic;
    private DraftLogic draftLogic;

    @BeforeClass
    public void beforeClass() {
        driver = getDriver();
        loginLogic = new LoginLogic(driver);
        draftLogic = new DraftLogic(driver);
        loadMainPage(driver);
        loginLogic.toLoginValidly();
    }

    @Test(priority = 1)
    public void testIsSavingLetterToDraftsSuccessful() {
        draftLogic.createLetterForDrafts(subjectForDrafts);
        draftLogic.saveLetterToDrafts();
        Assert.assertTrue(draftLogic.isSavingLetterToDraftsSuccessful());
    }

    @Test(priority = 2)
    public void testIsThereSpecificLetterInDrafts() {
        driver.navigate().refresh();
        Assert.assertTrue(draftLogic.isThereSpecificLetterInDrafts());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

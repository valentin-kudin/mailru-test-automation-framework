package base;

import logic.LoginLogic;
import logic.NewFolderLogic;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewFolderLogicTest extends BaseTest {

    private WebDriver driver;
    private LoginLogic loginLogic;
    private NewFolderLogic newFolderLogic;

    @BeforeClass
    public void beforeClass() {
        driver = getDriver();
        loginLogic = new LoginLogic(driver);
        newFolderLogic = new NewFolderLogic(driver);
        loadMainPage(driver);
        loginLogic.toLoginValidly();
    }

    @Test(priority = 1)
    public void testIsFolderCreationSuccessful() {
        newFolderLogic.createNewFolder();
        Assert.assertTrue(newFolderLogic.isFolderVisible());
    }

    @Test(priority = 2)
    public void testIsFolderDeletionSuccessful() {
        newFolderLogic.deleteFolder();
        driver.navigate().refresh();
        Assert.assertFalse(newFolderLogic.isFolderVisible());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

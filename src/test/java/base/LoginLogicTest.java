package base;

import logic.LoginLogic;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginLogicTest extends BaseTest {

    private WebDriver driver;
    private LoginLogic loginLogic;

    @BeforeClass
    public void beforeClass() {
        driver = getDriver();
        loginLogic = new LoginLogic(driver);
        loadMainPage(driver);
    }

    @Test
    public void testIsLoginSuccessful() {
        loginLogic.toLogin(userLogin, userPassword);
        Assert.assertTrue(loginLogic.isLoginSuccessful());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

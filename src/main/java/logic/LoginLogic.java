package logic;

import core.logfourj.LoggerInitializing;
import core.parser.dom.UserOperations;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginLogic {

    private UserOperations userOperations = new UserOperations();
    private LoginPage loginPage;
    private Logger logger = LoggerInitializing.getLogger(this.getClass());

    public LoginLogic(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void toLogin(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        logger.info("Login");
    }

    public void toLoginValidly() {
        loginPage.enterLogin(userOperations.getUserLogin("valid"));
        loginPage.enterPassword(userOperations.getUserPassword("valid"));
        logger.info("Login with valid credentials");
    }

    public boolean isLoginSuccessful() {
        return loginPage.isInboxButtonVisible();
    }
}

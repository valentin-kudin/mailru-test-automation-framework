package logic.steps;

import core.apivk.WallOperations;
import core.configuration.ConfigurationBrowser;
import core.mysql.MailRuTestDataConnection;
import core.mysql.models.Letter;
import core.parser.dom.UserOperations;
import core.selenium.webdriver.DriverManagerFactory;
import core.util.regex.StringOperationsApiVk;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.InboxPage;
import pages.LoginPage;

public abstract class BaseSteps {

    private UserOperations userOperations = new UserOperations();
    private MailRuTestDataConnection mailRuTestDataConnection = new MailRuTestDataConnection();
    private WallOperations vkWallOperations = new WallOperations();
    private StringOperationsApiVk operationsApiVk = new StringOperationsApiVk();

    private final String ADDRESSEE_FIELD_NAME = "addressee";
    private final String SUBJECT_FIELD_NAME = "subject";
    private final String MESSAGE_FIELD_NAME = "message";
    private Letter letter = mailRuTestDataConnection.getSpecificLetterFromDatabase(0);
    private Letter randomLetter = mailRuTestDataConnection.getRandomLetterFromDatabase();

    protected Logger logger;
    protected String userLogin = userOperations.getUserLogin("valid");
    protected String userPassword = userOperations.getUserPassword("valid");
    protected int numberOfFlags = 3;

    protected String addressee = getDataFromDefaultLetter(ADDRESSEE_FIELD_NAME);
    protected String subject = getDataFromDefaultLetter(SUBJECT_FIELD_NAME);
    protected String message = getDataFromDefaultLetter(MESSAGE_FIELD_NAME);
    //protected String messageFromVkWall = getDataFromDataBaseThroughVkApi();

    protected WebDriver getDriver() {
        return  DriverManagerFactory.getManager(ConfigurationBrowser.getDriverType()).getDriver();
    }

    protected void toLoginValidly(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLogin(userLogin);
        loginPage.enterPassword(userPassword);
    }

    protected void loadMainPage(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get(ConfigurationBrowser.getMainPageUrl());
    }

    private String getDataFromLetter(Letter letter, String letterField) {
        String data = "";
        switch (letterField) {
            case "addressee":
                data = letter.getAddressee();
                break;
            case "subject":
                data = letter.getSubject();
                break;
            case "message":
                data = letter.getMessage();
                break;
            default:
                data = "";
        }
        return data;
    }

    public Letter getSpecificLetter(int letterIndex) {
        return mailRuTestDataConnection.getSpecificLetterFromDatabase(letterIndex);
    }

    private String getDataFromDefaultLetter(String letterField) {
        return getDataFromLetter(letter, letterField);
    }

    private String getDataFromDataBaseThroughVkApi() {
        vkWallOperations.postMessageOnWall(getDataFromLetter(randomLetter, MESSAGE_FIELD_NAME));
        String response = vkWallOperations.getPostsFromWall("1");
        vkWallOperations.deletePostFromWall(operationsApiVk.getPostIdFromString(response));
        return operationsApiVk.getWallPostText(response);
    }
}


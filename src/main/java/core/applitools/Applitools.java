package core.applitools;

import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import core.selenium.webdriver.WebDriverSingleton;
import core.configuration.ConfigurationApplitools;
import core.configuration.ConfigurationBrowser;
import org.openqa.selenium.WebDriver;

public class Applitools {
    private Eyes eyes;
    private EyesRunner eyesRunner;
    private static final WebDriver CHROME_DRIVER = WebDriverSingleton.getWebDriver(ConfigurationBrowser.getDriverType());
    private static final String APP_NAME = ConfigurationApplitools.getAppName();
    private static final String TEST_NAME = ConfigurationApplitools.getTestName();
    private static final int RESOLUTION_WIDTH = ConfigurationApplitools.getResolutionWidth();
    private static final int RESOLUTION_HEIGHT = ConfigurationApplitools.getResolutionHeight();
    private static final MatchLevel MATCH_LEVEL = MatchLevel.CONTENT;

    public Applitools() {
        eyesRunner = new ClassicRunner();
        eyes = new Eyes(eyesRunner);
        eyes.setApiKey("2ouastvrSnr8WxVxU784wA75Y4JskECI19Bj0tRF7bE110");
    }

    public void openEyes() {
        eyes.open(CHROME_DRIVER, APP_NAME, TEST_NAME, new RectangleSize(RESOLUTION_WIDTH, RESOLUTION_HEIGHT));
        eyes.setMatchLevel(MATCH_LEVEL);
    }

    public void checkWindow(String screenshotName) {
        eyes.checkWindow(screenshotName);
    }

    public TestResults getTestResults() {
        return eyes.close(false);
    }

    public TestResultsSummary getTestResultsSummary() {
        TestResultsSummary testResultsSummary = eyesRunner.getAllTestResults();
        return testResultsSummary;
    }

    public void closeAsyncEyes() {
        eyes.closeAsync();
    }

    public void snatchEyes() {
        eyes.abortIfNotClosed();
    }

    public boolean doAllScreenshotsMatchBaseline(int numberOfScreenshots) {
        return getTestResults().getMatches() == numberOfScreenshots;
    }
}


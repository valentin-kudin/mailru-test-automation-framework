package core.configuration;

import core.selenium.webdriver.DriverType;

import java.util.Properties;

public class ConfigurationBrowser extends Configuration{

    private static Properties properties;

    public static void readProperties() {
        properties = createProperties();
        loadProperties("env.properties", properties);
        loadProperties("chrome.properties", properties);
        loadProperties("browser.properties", properties);
    }

    public static void initializeProperties() {
        if (properties == null) {
            readProperties();
        }
    }

    public static DriverType getDriverType() {
        initializeProperties();
        return DriverType.valueOf(properties.getProperty("browserType"));
    }

    public static String getMainPageUrl() {
        initializeProperties();
        return properties.getProperty("mainUrl");
    }

    public static boolean isHeadless() {
        initializeProperties();
        boolean isHeadless = false;
        if (properties.getProperty("headless").equals("true")) {
            isHeadless = true;
        }
        return isHeadless;
    }
}

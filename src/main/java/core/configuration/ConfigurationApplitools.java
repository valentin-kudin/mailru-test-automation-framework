package core.configuration;

import java.util.Properties;

public class ConfigurationApplitools extends Configuration {

    private static Properties properties;

    public static void readProperties() {
        properties = createProperties();
        loadProperties("applitools.properties", properties);
    }

    public static void initializeProperties() {
        if (properties == null) {
            readProperties();
        }
    }

    public static String getAppName() {
        initializeProperties();
        return properties.getProperty("appName");
    }

    public static String getTestName() {
        initializeProperties();
        return properties.getProperty("testName");
    }

    public static int getResolutionWidth() {
        initializeProperties();
        return Integer.parseInt(properties.getProperty("resolutionWidth"));
    }

    public static int getResolutionHeight() {
        initializeProperties();
        return Integer.parseInt(properties.getProperty("resolutionHeight"));
    }
}

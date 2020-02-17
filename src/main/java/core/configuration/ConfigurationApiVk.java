package core.configuration;

import core.apivk.AccessTokenScope;

import java.util.Properties;

public class ConfigurationApiVk extends Configuration{

    private static Properties properties;

    public static void readProperties() {
        properties = createProperties();
        loadProperties("apivk.properties", properties);
    }

    public static void initializeProperties() {
        if (properties == null) {
            readProperties();
        }
    }

    public static String getAccessToken(AccessTokenScope accessTokenScope) {
        String accessToken = "";
        initializeProperties();
        switch (accessTokenScope) {
            case WALL:
                accessToken = properties.getProperty("wallScopeAccessToken");
                break;
            case FRIENDS:
                accessToken = properties.getProperty("friendsScopeAccessToken");
                break;
            default:
                accessToken = properties.getProperty("friendsScopeAccessToken");
                break;
        }
        return accessToken;
    }

    public static String getVersion() {
        initializeProperties();
        return properties.getProperty("version");
    }

    public static String getWallOwnerId() {
        initializeProperties();
        return properties.getProperty("wallOwnerId");
    }
}

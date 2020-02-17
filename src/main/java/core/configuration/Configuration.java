package core.configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public abstract class Configuration {

    public static Properties createProperties() {
        return new Properties();
    }

    public static void loadProperties(String propertyFileName, Properties properties) {
        try {
            properties.load(new FileReader(new File("src/main/resources/properties", propertyFileName)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

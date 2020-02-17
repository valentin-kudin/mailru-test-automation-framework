package core.logfourj;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerInitializing {

    private static final String PATH_TO_PROPERTY_FILE = "src/main/resources/properties/log4j.properties";

    public static Logger getLogger(Class clazz) {
        Logger logger = Logger.getLogger(clazz);
        PropertyConfigurator.configure(PATH_TO_PROPERTY_FILE);
        return logger;
    }
}

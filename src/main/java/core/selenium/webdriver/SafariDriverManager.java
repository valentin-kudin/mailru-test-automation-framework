package core.selenium.webdriver;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;

import java.io.File;

public class SafariDriverManager extends DriverManager {

    private SafariDriverService safariDriverService;

    @Override
    public void startService() {
        if (null == safariDriverService) {
            try {
                safariDriverService = new SafariDriverService.Builder()
                        .usingDriverExecutable(new File("/usr/bin/safaridriver"))
                        .usingAnyFreePort()
                        .build();
                safariDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != safariDriverService && safariDriverService.isRunning())
            safariDriverService.stop();
    }

    @Override
    public void createDriver() {
//        SafariOptions options = new SafariOptions();
//        options
        driver = new SafariDriver(safariDriverService);
    }
}
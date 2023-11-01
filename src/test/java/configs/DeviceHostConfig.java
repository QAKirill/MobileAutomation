package configs;

import drivers.BrowserstackDriver;
import drivers.LocalDriver;

public class DeviceHostConfig {
    private String host = System.getProperty("deviceHost");

    public String getConfig() {
        switch (host) {
            case ("browserstack"):
                return BrowserstackDriver.class.getName();
            default:
                return LocalDriver.class.getName();
        }
    }
}
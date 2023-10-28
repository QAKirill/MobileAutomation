package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.AuthConfig;
import configs.DeviceConfig;
import helpers.ConfigReader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        AuthConfig authConfig = ConfigReader.INSTANCE.getAuthConfig();
        DeviceConfig deviceConfig = ConfigReader.INSTANCE.getDeviceConfig();

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", authConfig.getUser());
        mutableCapabilities.setCapability("browserstack.key", authConfig.getKey());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", "bs://sample.app");//"bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", deviceConfig.getDeviceName());
        mutableCapabilities.setCapability("os_version", deviceConfig.getOsVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(authConfig.getURL()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
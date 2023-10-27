package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import helpers.Attach;
import helpers.Credentials;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;

        Credentials.user = System.getProperty("user", "ivanovivan_Mubgxt");
        Credentials.key = System.getProperty("key", "czPhMp9qsL7c22N23D9M");
    }

    @BeforeEach
    public void beforeEach(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        //Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        String sessionId = Selenide.sessionId().toString();
        closeWebDriver();

        Attach.addVideo(sessionId);
    }
}

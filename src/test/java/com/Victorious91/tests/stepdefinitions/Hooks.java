package com.Victorious91.tests.stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.Victorious91.tests.config.TestConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        Configuration.browser = TestConfig.browser();
        Configuration.headless = TestConfig.headless();
        Configuration.baseUrl = TestConfig.baseUrl();
        Configuration.timeout = 6000;
        Configuration.browserSize = "1366x768";
        Configuration.screenshots = false;   // facem noi screenshot-ul, atasat in raport
        Configuration.savePageSource = false;
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && WebDriverRunner.hasWebDriverStarted()) {
            byte[] png = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(png, "image/png", "Screenshot la esec");
            logDiagnostics(scenario);
        }
        Selenide.closeWebDriver();
    }

    /** La esec afisam URL-ul, titlul si inceputul textului paginii, ca sa vedem unde s-a oprit testul. */
    private void logDiagnostics(Scenario scenario) {
        try {
            String body = Selenide.$("body").getText().replaceAll("\\s+", " ");
            if (body.length() > 500) {
                body = body.substring(0, 500) + "...";
            }
            String info = "URL: " + WebDriverRunner.url() + " | TITLU: " + Selenide.title() + " | TEXT: " + body;
            scenario.log(info);
            System.out.println("[DIAGNOSTIC] " + scenario.getName() + " -> " + info);
        } catch (Exception e) {
            System.out.println("[DIAGNOSTIC] indisponibil: " + e.getMessage());
        }
    }
}

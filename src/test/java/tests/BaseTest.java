package tests;

import io.qameta.allure.Step;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    @BeforeSuite
    public void initDriver() {
        browser = DriverInstance.class.getName();
    }

    @Step("Open url")
    public void openUrl(String url) {
        open(url);
    }
}
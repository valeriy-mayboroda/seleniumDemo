package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    @BeforeSuite
    public void initDriver() {
        browserSize = "1280x1080";
        browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setWebDriver(driver);
    }
}
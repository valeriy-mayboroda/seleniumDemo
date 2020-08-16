package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class TagsTests {

    @Test
    public void checkTagPresenceInAllArticles(){
        open("https://demo.realworld.io/");
        new HomePage()
                .filterByTag("test")
                .checkTagPresenceInAllArticles("test");
    }
}
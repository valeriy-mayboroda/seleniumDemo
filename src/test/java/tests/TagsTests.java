package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class TagsTests extends BaseTest {

    @Test(description = "Select tag feed, check tag presence in every article")
    public void checkTagPresenceInAllArticles() {
        openUrl("https://demo.realworld.io/");
        new HomePage()
                .selectTagFeedOnPopularTagMenu("test")
                .checkPresenceTagFeed("test")
                .checkTagPresenceInEveryArticle("test");
    }
}
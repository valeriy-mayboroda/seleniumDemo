package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends BasePage {
    private String selectTag = "//a[contains(@class, 'tag-pill')][text() = '%s']";
    private By allItemTagList = By.cssSelector("ul.tag-list");
    private By itemTags = By.tagName("li");
    private By tagFeed = By.cssSelector("li[ng-show]");

    @Step("Check presence '{0}' feed ")
    public HomePage checkPresenceTagFeed(String tag) {
        $$(tagFeed).shouldHave(CollectionCondition.size(1))
                .first().$(withText(tag)).shouldBe(Condition.visible);
        getLogger().info(String.format("Tag feed #%s is presence", tag));
        return this;
    }

    @Step("Select tag feed on popular tag menu")
    public HomePage selectTagFeedOnPopularTagMenu(String name) {
        $(By.xpath(String.format(selectTag, name))).click();
        getLogger().info(String.format("Tag %s is selected on popular tags menu", name));
        return this;
    }

    @Step("Check tag presence in every result article")
    public HomePage checkTagPresenceInAllArticles(String name) {
        //Find all articles
        int expectedArticleSize = 10;
        List <SelenideElement> results = $$(allItemTagList).shouldHave(CollectionCondition.size(expectedArticleSize));
        getLogger().info(String.format("%d articles are found on feed", expectedArticleSize));
        //Find tags in every articles
        results.forEach(item -> {
            //Every article should have tags
            List<SelenideElement> list = item.$$(itemTags).shouldHave(CollectionCondition.sizeGreaterThan(0));
            //Check tag {name} presence in article tags
            boolean mustBe = false;
            for (int i = 0; i < list.size(); i ++) {
                mustBe = list.get(i).getText().trim().equals(name);
                if (mustBe) {
                    getLogger().info(String.format("Tag %s is found in article", name));
                    break;
                }
            }
            Assert.assertTrue(mustBe, String.format("Tag %s is absence in article", name));
        });
        return this;
    }
}
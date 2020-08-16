package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {
    private String selectTag = "//a[contains(@class, 'tag-pill')][text() = '%s']";
    private By allItemTagList = By.cssSelector("ul.tag-list");
    private By itemTags = By.tagName("li");

    @Step("Filter results by tag")
    public HomePage filterByTag(String name) {
        $(By.xpath(String.format(selectTag, name))).click();
        return this;
    }

    @Step("Check tag presence in every result article")
    public HomePage checkTagPresenceInAllArticles(String name) {
        $$(allItemTagList).forEach(item -> {
            List<SelenideElement> list = $$(itemTags);
            boolean mustBe = false;
            for (int i = 0; i < list.size(); i ++) {
                mustBe = list.get(i).getText().trim().equals(name);
                if (mustBe) break;
            }
            Assert.assertTrue(mustBe, String.format("Tag %s is absence in article"));
        });
        return this;
    }
}
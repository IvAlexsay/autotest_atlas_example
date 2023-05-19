import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import Elements.RepositoryCard;
import Site.GitHubSite;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebDriverConfiguration;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static ru.yandex.qatools.matchers.webdriver.TextMatcher.text;
import static org.hamcrest.Matchers.hasSize;

public class GitHubTestsWithAtlas {
    private WebDriver driver;
    private Atlas atlas;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\roman\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
        atlas = new Atlas(new WebDriverConfiguration(driver, "https://github.com"));
    }

    @Test
    public void searchAtlasRepoTest() {
        onSite().onMainPage().open();
        onSite().onMainPage().header().searchInput().sendKeys("Atlas");
        onSite().onMainPage().header().searchInput().submit();
        onSite().onSearchPage("Junit 5").repositories().waitUntil(hasSize(10));
    }

    @Test
    public void searchJunitRepos() {
        onSite().onSearchPage("Junit 5").repositories().waitUntil(hasSize(10))
                .should(everyItem(text(containsString("junit"))));
    }

    @Test
    public void checkContributorsPage() {
        onSite().onProjectPage("qameta", "atlas").contributors().click();
        onSite().onContributorsPage().hovercards().waitUntil(hasSize(8));
    }

    @Test
    public void shouldExtractRepositoriesInfo() {
        ElementsCollection<String> nameOfRepositories = onSite().onSearchPage("Junit 5").repositories()
                .extract(RepositoryCard::title)
                .extract(AtlasWebElement::getText);
        nameOfRepositories.should(everyItem(anyOf(containsString("junit"))));
    }


    private GitHubSite onSite() {
        return atlas.create(driver, GitHubSite.class);
    }

    @After
    public void stopDriver() {
        driver.quit();
    }
}

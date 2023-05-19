package Pages;

import Elements.RepositoryCard;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface SearchPage extends WebPage, WithHeader {

    @FindBy(".//ul[contains(@class, 'repo-list')]//li[contains(@class, 'repo-list-item')]")
    ElementsCollection<RepositoryCard> repositories();

}
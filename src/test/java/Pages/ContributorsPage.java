package Pages;

import Elements.RepositoryCard;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface ContributorsPage extends WebPage, WithHeader {

    @FindBy(".//ol[contains(@class, 'contrib-data')]//li[contains(@class, 'contrib-person')]")
    ElementsCollection<RepositoryCard> hovercards();
}

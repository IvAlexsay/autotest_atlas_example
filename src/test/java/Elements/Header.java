package Elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Header extends AtlasWebElement {

    @FindBy(".//input[contains(@class,'header-search-input')]")
    AtlasWebElement searchInput();
}

package Pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface ProjectPage extends WebPage, WithHeader {

    @FindBy("//a[contains(@href,'contributors')]")
    AtlasWebElement contributors();
}
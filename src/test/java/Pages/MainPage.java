package Pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface MainPage extends WebPage, WithHeader {

    @FindBy("//a[contains(text(), 'Or start a free trial of Enterprise Server')]")
    AtlasWebElement trial();
}
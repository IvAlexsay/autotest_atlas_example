package layout;

import Elements.Header;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithHeader {

    @FindBy("//header[contains(@class,'Header')]")
    Header header();
}
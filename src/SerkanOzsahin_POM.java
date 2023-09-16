import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SerkanOzsahin_POM {

    public SerkanOzsahin_POM() {PageFactory.initElements(BaseDriver.driver, this);}

    @FindBy(css = "ul[class='top-menu notmobile'] > li")
    public List<WebElement> tabMenuListCheck;

    @FindBy(css = "div[class='page-title'] > h1")
    public WebElement textCheck;

    @FindBy(css = "div[class='page-title'] > h1")
    public WebElement subMenuTextCheck;
}

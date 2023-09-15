import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iremPOM {
    public iremPOM(){ PageFactory.initElements(BaseDriver.driver,this);}

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement Login;

    @FindBy(css = "input[class='email input-validation-error']")
    public WebElement Mail;

    @FindBy(css = "input[class='password valid']")
    public WebElement Password;

    @FindBy(css = "button[class='button-1 login-button']")
    public WebElement LOGIN;



}

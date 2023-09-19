import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class nurhayat_POM extends BaseDriver {
    public nurhayat_POM(){
        PageFactory.initElements(BaseDriver.driver, this);
    }
    @FindBy(css = "[class='ico-register'] ")
    public WebElement register;

    @FindBy(css = "[class='female']")
    public WebElement famale;

    @FindBy(css = "[id='FirstName'] ")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name= "DateOfBirthDay")
    public WebElement webDay;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement webMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement webYear;

    @FindBy(id = "Email")
    public WebElement Email;

    @FindBy(id = "Newsletter")
    public WebElement newsletter;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(css = "[id='register-button']")
    public WebElement registerbtn;

    @FindBy(css= "[class='button-1 register-continue-button']")
    public WebElement conbtn;

}

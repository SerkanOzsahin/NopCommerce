import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NopCommerce_POM {

    public NopCommerce_POM() {PageFactory.initElements(BaseDriver.driver, this);}

    @FindBy(css = "ul[class='top-menu notmobile'] > li")
    public List<WebElement> tabMenuListCheck;

    @FindBy(css = "div[class='page-title'] > h1")
    public WebElement textCheck;

    @FindBy(css = "div[class='page-title'] > h1")
    public WebElement subMenuTextCheck;

    @FindBy(id = "small-searchterms")
    public WebElement searchBox;

    @FindBy(css = "div[class='page-title'] > h1")
    public WebElement searchTextConfirm;

    @FindBy(css = "h2[class='product-title'] a")
    public WebElement productName;

    @FindBy(css = "div[class='details'] a")
    public List<WebElement> productNames;

    @FindBy(css = "[class='ico-register'] ")
    public WebElement register;

    @FindBy(css = "[class='female']")
    public WebElement famale;

    @FindBy(css = "[id='FirstName'] ")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
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

    @FindBy(css = "[class='button-1 register-continue-button']")
    public WebElement conbtn;

    @FindBy(css = "[class='header-links'] > ul :nth-child(2)")
    public WebElement LoginButton;

    @FindBy(name = "Email")
    public WebElement EmailName;

    @FindBy(name = "Password")
    public WebElement Password;

    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement LoginClick;

    @FindBy(xpath = "//*[@class='top-menu notmobile']/*[1]")
    public WebElement Computers;

    @FindBy(css = "[href='/desktops']")
    public WebElement Desktops;

    @FindBy(xpath = "(//*[@href='/desktops'])[3]")
    public WebElement DesktopsLeft;

    @FindBy(xpath = "(//*[@class='product-item'])[1]")
    public WebElement BuildCompt;

    @FindBy(name = "product_attribute_1")
    public WebElement Processor;

    @FindBy(xpath = "//*[@name='product_attribute_2']/*")
    public List<WebElement> Ram;

    @FindBy(id = "product_attribute_2")
    public WebElement RandomRam;

    @FindBy(css = "[id='product_attribute_input_3'] li input")
    public List<WebElement> HDD;

    @FindBy(css = "[id='product_attribute_input_4'] li input")
    public List<WebElement> OS;

    @FindBy(css = "[id='product_attribute_input_5'] li input")
    public List<WebElement> SoftWare;

    @FindBy(id = "add-to-cart-button-1")
    public WebElement AddToCart;

    @FindBy(id = "topcartlink")
    public WebElement ShoppingCart;

    @FindBy(className = "product-name")
    public WebElement ConfrimProduct;

    @FindBy(css = "[class='bar-notification error']")
    public WebElement WrongMessage;

    @FindBy(xpath = "(//*[@href='/gift-cards'])[1]")
    public WebElement GiftCardButton;

    @FindBy(css = "[class='button-2 product-box-add-to-cart-button']")
    public List<WebElement> AddCart;

    @FindBy(className = "recipient-name")
    public WebElement RecipientName;

    @FindBy(className = "recipient-email")
    public WebElement RecipientEmail;

    @FindBy(id = "giftcard_45_SenderName")
    public WebElement YourName;

    @FindBy(xpath = "(//*[@type='button'])[2]")
    public WebElement Cart;

    @FindBy(css = "ul[class='top-menu notmobile'] > li")
    public List<WebElement> TopMenu;

    @FindBy(css = "[class='top-menu notmobile'] a")
    public List<WebElement> ProductMenu;

    @FindBy(css = "ul[class='top-menu notmobile'] >li li")
    public List<WebElement> items;

    @FindBy(className = "product-title")
    public List<WebElement> ProductList;

    @FindBy(xpath = "(//*[@href='/computers'])[3]")
    public WebElement ComputersButton;

    @FindBy(xpath = "(//*[@href='/electronics'])[3]")
    public WebElement ElectronicsButton;

    @FindBy(css = "[class='sub-category-item']")
    public List<WebElement> Products;

    @FindBy(xpath = "(//*[@href='/apparel'])[3]")
    public WebElement ApparelButton;

    @FindBy(xpath = "(//*[@href='/digital-downloads'])[3]")
    public WebElement DigitalDowlandsButton;

    @FindBy(xpath = "(//*[@href='/books'])[3]")
    public WebElement BooksButton;

    @FindBy(xpath = "(//*[@href='/jewelry'])[3]")
    public WebElement JewelryButton;

    @FindBy(xpath = "(//*[@href='/gift-cards'])[3]")
    public WebElement GiftCardsButton;

    @FindBy(css = "[placeholder='Search store']")
    public WebElement Searchbox;

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement Login;

    @FindBy(css = "input[class='email']")
    public WebElement Mail;

    @FindBy(css = "button[class='button-1 login-button']")
    public WebElement LOGIN;
}

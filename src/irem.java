import Utility.BaseDriver;
import Utility.MyFunc;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import com.sun.xml.internal.ws.api.message.Message;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class irem extends BaseDriver {
    String mail1 = "iremt8202@gmail.com";
    String password1 = "fhfrnf45689";
    String mail2 = "iremmmfhh@gmail.com";
    String mail3 = "";
    String password2 = "gtfeggh123AB";
    String password3 = "";

    @Test
    public void NegativeLogin1() {
        iremPOM e = new iremPOM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
        e.Mail.sendKeys(mail1);
        e.Password.sendKeys(password1);
        wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
        e.LOGIN.click();

    }
    @Test
    public void NegativeLogin2(){
        iremPOM e = new iremPOM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
        e.Mail.sendKeys(mail1);
        e.Password.sendKeys(password2);
        wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
        e.LOGIN.click();

    }
    @Test
    public void NegativeLogin3(){
        iremPOM e = new iremPOM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
        e.Mail.sendKeys(mail1);
        e.Password.sendKeys(password3);
        wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
        e.LOGIN.click();
    }
    @Test
    public void NegativeLogin4(){
        iremPOM e = new iremPOM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
        e.Mail.sendKeys(mail2);
        e.Password.sendKeys(password1);
        wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
        e.LOGIN.click();
    }
    @Test
    public void NegativeLogin5(){
        iremPOM e = new iremPOM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
        e.Mail.sendKeys(mail2);
        e.Password.sendKeys(password3);
        wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
        e.LOGIN.click();
    }
    @Test
    public void PositiveLogin(){
        iremPOM e = new iremPOM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
        e.Mail.sendKeys(mail1);
        e.Password.sendKeys(password2);
        wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
        e.LOGIN.click();

    }


    }

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class irem extends BaseDriver {
    String validUsername = "iremt8202@gmail.com";
    String invalidPassword = "fhfrnf45689";
    String invalidUsername = "iremmmfhh@gmail.com";

    String validPassword = "gtfeggh123AB";


    @Test(dataProvider = "userData",groups ="Smoke Test")
    public void NegativeLogin(String USERNAME,String PASSWORD) {
        iremPOM e = new iremPOM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
        e.Mail.sendKeys(USERNAME);
        e.Password.sendKeys(PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
        e.LOGIN.click();
        WebElement unsuccessful=driver.findElement(By.cssSelector("div[class='message-error validation-summary-errors']"));
        Assert.assertTrue(unsuccessful.getText().contains("Login was unsuccessful"));

    }
    @DataProvider
    public Object[][] userData() {

        Object[][] invalidData = {{validUsername,invalidPassword}, {invalidUsername,validPassword}, {invalidUsername,invalidPassword}};
        return invalidData;
    }

    @Parameters({"username","password"})
    @Test(groups ="Smoke Test")
    public void PositiveLogin(String username,String password){
        iremPOM e = new iremPOM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
        e.Mail.sendKeys(username);
        e.Password.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
        e.LOGIN.click();
    }
   @Test(dataProvider = "nullData",groups ="Smoke Test")
    public void nullLogin(String username,String password) {
       iremPOM e = new iremPOM();
       driver.get("https://demo.nopcommerce.com/");
       wait.until(ExpectedConditions.elementToBeClickable(e.Login));
       e.Login.click();
       wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
       e.Mail.sendKeys(username);
       e.Password.sendKeys(password);
       wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
       e.LOGIN.click();
   }
    @DataProvider
    public Object[][]nullData(){
        Object[][]userNullData= {{validUsername,""}, {"",validPassword}, {"",""}};
        return  userNullData;
    }

    }

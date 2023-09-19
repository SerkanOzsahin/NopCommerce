import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ayca extends BaseDriver {
    @Test
    public void Login_test(){
        String userMail= "hamzihamda@gmail.com";

        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);
        WebElement loginButton =driver.findElement(By.linkText("Log in"));
        loginButton.click();
        MyFunc.Wait(2);
        WebElement eMail=driver.findElement(By.id("Email"));
        eMail.sendKeys(userMail);
        MyFunc.Wait(2);
        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("123456789");
        MyFunc.Wait(2);
        WebElement submitButton=driver.findElement(By.xpath("//button[text()='Log in']"));
        submitButton.click();
        MyFunc.Wait(2);
        WebElement myAcc=driver.findElement(By.linkText("My account"));
        myAcc.click();
        WebElement eMailConfirm=driver.findElement(By.cssSelector("input[id='Email']"));
        MyFunc.Wait(2);

        Assert.assertTrue(userMail.equals(eMailConfirm.getAttribute("value")));

    }
}

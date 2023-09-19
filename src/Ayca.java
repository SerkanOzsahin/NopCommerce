import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ayca extends BaseDriver {
    @Test
    public void Login_test(){
        driver.get("https://demo.nopcommerce.com/");
        WebElement loginButton =driver.findElement(By.linkText("Log in"));
        loginButton.click();

        WebElement eMail=driver.findElement(By.id("Email"));
        eMail.sendKeys("hamzihamda@gmail.com");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("123456789");

        WebElement submitButton=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        submitButton.click();

        WebElement myAcc=driver.findElement(By.linkText("My account"));
        myAcc.click();
        WebElement eMailConfirm=driver.findElement(By.className("valid"));
        eMailConfirm.getText();
    }
}

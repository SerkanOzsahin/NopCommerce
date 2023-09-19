import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ayca extends BaseDriver {
    @Test
    public void Login_test(){
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(1);
        WebElement email=driver.findElement(By.xpath("//input[@id='email'])"));
        email.sendKeys("email");
        MyFunc.Wait(1);
        WebElement Password=driver.findElement(By.xpath("//input[@id='Password'])"));
        Password.sendKeys("Password");
        MyFunc.Wait(1);
        WebElement LoginButton=driver.findElement(By.xpath("//input[@id='login-button'])"));
        LoginButton.click();
    }
}

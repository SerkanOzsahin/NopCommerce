import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class nurhayat extends BaseDriver {
    @Test
    public void giftsCard(){
        driver.get("https://demo.nopcommerce.com/");

        WebElement register= driver.findElement(By.cssSelector("[class='ico-register'] "));
        register.click();
        WebElement famale= driver.findElement(By.cssSelector("[class='female']"));
        famale.click();
        WebElement firstName= driver.findElement(By.cssSelector("[id='FirstName'] "));
        firstName.sendKeys("Nur");
        WebElement lastName= driver.findElement(By.id("LastName"));
        lastName.sendKeys("Test");

        WebElement webDay=driver.findElement(By.name("DateOfBirthDay"));
        WebElement webMonth=driver.findElement(By.name("DateOfBirthMonth"));
        WebElement webYear=driver.findElement(By.name("DateOfBirthYear"));

        Select day=new Select(webDay);
        Select month=new Select(webMonth);
        Select year=new Select(webYear);

        day.selectByVisibleText("21");
        month.selectByValue("4");
        year.selectByVisibleText("2000");

        WebElement Email= driver.findElement(By.id("Email"));
        Email.sendKeys("yaban@gmail.com");

        WebElement companyName= driver.findElement(By.id("Company"));
        Email.sendKeys("nurltd.şti");

        WebElement newsletter= driver.findElement(By.id("Newsletter"));
        newsletter.click();

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("123456");
        WebElement confirmPassword= driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("123456");
        WebElement registr= driver.findElement(By.cssSelector("[id='register-button']"));
        registr.click();
        MyFunc.Wait(3);








    }
}

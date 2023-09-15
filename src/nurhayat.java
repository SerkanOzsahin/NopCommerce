import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class nurhayat extends BaseDriver {
    @Test
    public void giftsCard(){
        nurhayat_POM e=new nurhayat_POM();
        driver.get("https://demo.nopcommerce.com/");

        e.register.click();
        e.famale.click();
        e.firstName.sendKeys("Team One");
        e.lastName.sendKeys("Techno");

        WebElement webDay=driver.findElement(By.name("DateOfBirthDay"));
        WebElement webMonth=driver.findElement(By.name("DateOfBirthMonth"));
        WebElement webYear=driver.findElement(By.name("DateOfBirthYear"));

        Select day=new Select(webDay);
        Select month=new Select(webMonth);
        Select year=new Select(webYear);

        day.selectByVisibleText("5");
        month.selectByValue("5");
        year.selectByVisibleText("2005");
        e.Email.sendKeys("t.one.techno3@gmail.com");

        e.newsletter.click();
        e.password.sendKeys("TOtechno1 ");
        e.confirmPassword.sendKeys("TOtechno1 ");
        e.registr.click();
        MyFunc.Wait(3);
        e.conbtn.click();
    }
}

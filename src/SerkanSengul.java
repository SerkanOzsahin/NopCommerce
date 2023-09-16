import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SerkanSengul extends BaseDriver {


    @Test
    public void Ordering_The_Computer() {
        SerkanSPOM e = new SerkanSPOM();

        driver.get("https://demo.nopcommerce.com/");
        e.LoginButton.click();
        e.EmailName.sendKeys("TestHamza@gmail.com");
        e.Password.sendKeys("kobe21tmac");
        e.LoginClick.click();
        e.Computers.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.DesktopsLeft));
        e.DesktopsLeft.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("desktops"));
        e.BuildCompt.click();
        Select ProcessorSelect = new Select(e.Processor);
        ProcessorSelect.selectByValue("1");

        Select RandomRam = new Select(e.RandomRam);
        int Option = e.Ram.size();
        Random Random = new Random();
        int randomidx = Random.nextInt(Option);
        RandomRam.selectByIndex(randomidx);
        wait.until(ExpectedConditions.elementToBeClickable(e.HDD.get(0)));

        int RandomHDD = MyFunc.randomGenerator(e.HDD.size());
        e.HDD.get(RandomHDD).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.OS.get(0)));

        int RandomOS = MyFunc.randomGenerator(e.OS.size());
        e.OS.get(RandomOS).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.SoftWare.get(0)));

        int RandomSoft = MyFunc.randomGenerator(e.SoftWare.size());
        e.SoftWare.get(RandomSoft).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.SoftWare.get(0)));

        wait.until(ExpectedConditions.elementToBeClickable(e.AddToCart));
        e.AddToCart.click();

        wait.until(ExpectedConditions.elementToBeClickable(e.ShoppingCart));
        e.ShoppingCart.click();


        String Confrim = e.ConfrimProduct.getText();
        Assert.assertTrue(e.ConfrimProduct.getText().equals(Confrim));

    }

    @Test
    public void Ordering_The_ComputeNegative() {
        SerkanSPOM e = new SerkanSPOM();
        driver.get("https://demo.nopcommerce.com/");
        e.LoginButton.click();
        e.EmailName.sendKeys("TestHamza@gmail.com");
        e.Password.sendKeys("kobe21tmac");
        e.LoginClick.click();
        e.Computers.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.DesktopsLeft));
        e.DesktopsLeft.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("desktops"));
        e.BuildCompt.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.HDD.get(0)));

        Select ProcessorSelect = new Select(e.Processor);
        ProcessorSelect.selectByValue("0");

        int RandomHDD = MyFunc.randomGenerator(e.HDD.size());
        e.HDD.get(RandomHDD).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.OS.get(0)));

        int RandomOS = MyFunc.randomGenerator(e.OS.size());
        e.OS.get(RandomOS).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.SoftWare.get(0)));

        int RandomSoft = MyFunc.randomGenerator(e.SoftWare.size());
        e.SoftWare.get(RandomSoft).click();
        wait.until(ExpectedConditions.elementToBeClickable(e.SoftWare.get(0)));

        wait.until(ExpectedConditions.elementToBeClickable(e.AddToCart));
        e.AddToCart.click();


        String ErrorMessage = e.WrongMessage.getText();
        Assert.assertTrue(e.WrongMessage.getText().equals(ErrorMessage));


    }
}


import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.*;

public class SerkanSengul extends BaseDriver {


     @Test(priority = 2)
       public void Ordering_The_Computer() {

        SerkanSPOM e = new SerkanSPOM();

        driver.get("https://demo.nopcommerce.com/");
        e.LoginButton.click();
        e.EmailName.sendKeys("hamzamemduh@gmail.com");
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

    @Test(priority = 3)
    public void Ordering_The_ComputeNegative() {
        SerkanSPOM e = new SerkanSPOM();
//        driver.get("https://demo.nopcommerce.com/");
//        e.LoginButton.click();
//        e.EmailName.sendKeys("hamzamemduh@gmail.com");
//        e.Password.sendKeys("kobe21tmac");
//        e.LoginClick.click();
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

    @Test(priority = 4)
    public void Gift_Ordering_Product() {
        SerkanSPOM e = new SerkanSPOM();
//        driver.get("https://demo.nopcommerce.com/");
//        e.LoginButton.click();
//        e.EmailName.sendKeys("hamzamemduh@gmail.com");
//        e.Password.sendKeys("kobe21tmac");
//        e.LoginClick.click();
       driver.navigate().back();
        e.GiftCardButton.click();

        int RandomGift = MyFunc.randomGenerator(e.AddCart.size());
        e.AddCart.get(RandomGift).click();

        e.RecipientName.sendKeys("Kerem");
//        e.RecipientEmail.sendKeys("keremler212@gmail.com");
        e.Cart.click();

        e.ShoppingCart.click();
        String Confrim = e.ConfrimProduct.getText();
        Assert.assertTrue(e.ConfrimProduct.getText().equals(Confrim));
        System.out.println("Confrim = " + Confrim);

    }

    @Test(priority = 5)
    public void Gift_Ordering_ProductNegavite() {

        SerkanSPOM e = new SerkanSPOM();
//        driver.get("https://demo.nopcommerce.com/");
//        e.LoginButton.click();
//        e.EmailName.sendKeys("hamzamemduh@gmail.com");
//        e.Password.sendKeys("kobe21tmac");
//        e.LoginClick.click();
        e.GiftCardButton.click();


        int RandomGift = MyFunc.randomGenerator(e.AddCart.size());
        e.AddCart.get(RandomGift).click();

        MyFunc.Wait(2);
        e.Cart.click();


        String ErrorMessage = e.WrongMessage.getText();
        Assert.assertTrue(e.WrongMessage.getText().equals(ErrorMessage));
        System.out.println("ErrorMessage = " + ErrorMessage);
    }

    @Test(parameters = "SearchText",priority = 1)

    public void ChallangeQuestion(String SearchingText) {
        SerkanSPOM e = new SerkanSPOM();
        List<String> TotalProduct = new ArrayList<>();
        List<WebElement> ProductElements = e.ProductList;
        driver.get("https://demo.nopcommerce.com/");
        e.Computers.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.DesktopsLeft));
        e.DesktopsLeft.click();
        e.ComputersButton.click();
        for (int i = 0; i < e.Products.size(); i++) {
            e.Products.get(i).click();
            MyFunc.Wait(1);
            for (WebElement productElement : ProductElements) {
                TotalProduct.add(productElement.getText());
            }
            driver.navigate().back();
        }
        e.ElectronicsButton.click();
        for (int i = 0; i < e.Products.size(); i++) {
            e.Products.get(i).click();
            MyFunc.Wait(2);
            for (WebElement productElement : ProductElements) {
                TotalProduct.add(productElement.getText());
            }
            driver.navigate().back();
        }
        e.ApparelButton.click();
        for (int i = 0; i < e.Products.size(); i++) {
            e.Products.get(i).click();
            MyFunc.Wait(1);
            for (WebElement productElement : ProductElements) {
                TotalProduct.add(productElement.getText());
            }
            driver.navigate().back();
        }
        e.DigitalDowlandsButton.click();
        for (int i = 0; i < e.ProductList.size(); i++) {
            TotalProduct.add(e.ProductList.get(i).getText());
        }
        e.BooksButton.click();
        for (int i = 0; i < e.ProductList.size(); i++) {
            TotalProduct.add(e.ProductList.get(i).getText());
        }
        e.JewelryButton.click();
        for (int i = 0; i < e.ProductList.size(); i++) {
            TotalProduct.add(e.ProductList.get(i).getText());
        }
        e.GiftCardsButton.click();
        for (int i = 0; i < e.ProductList.size(); i++) {
            TotalProduct.add(e.ProductList.get(i).getText());
        }
        MyFunc.Wait(2);
        e.Searchbox.sendKeys(SearchingText + Keys.ENTER);
        MyFunc.Wait(2);
        for (String product : TotalProduct) {
            System.out.println("product = " + product);
            if (product.equalsIgnoreCase(SearchingText)) {
                System.out.println("Ürün bulundu"+SearchingText);
                break;

            }


        }


    }
}




























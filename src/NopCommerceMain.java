import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NopCommerceMain extends BaseDriver {

    String validUsername = "grp3ts@gmail.com";
    String validPassword = "techno123";
    String invalidUsername = "iremkekw@gmail.com";
    String invalidPassword = "123456";

    @Test(groups = {"Smoke Test"}, priority = 1)
    public void creatingAUser() { // Assigned to Nurhayat / UserStory-1

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);
        e.register.click();
        e.famale.click();
        e.firstName.sendKeys("Team One");
        e.lastName.sendKeys("Techno");
        WebElement webDay = driver.findElement(By.name("DateOfBirthDay"));
        WebElement webMonth = driver.findElement(By.name("DateOfBirthMonth"));
        WebElement webYear = driver.findElement(By.name("DateOfBirthYear"));
        Select day = new Select(webDay);
        Select month = new Select(webMonth);
        Select year = new Select(webYear);
        day.selectByVisibleText("5");
        month.selectByValue("5");
        year.selectByVisibleText("2005");
        e.Email.sendKeys(validUsername);
        e.newsletter.click();
        e.password.sendKeys(validPassword);
        e.confirmPassword.sendKeys(validPassword);
        e.registerbtn.click();
        MyFunc.Wait(3);
        e.conbtn.click();
    }

    @Test(groups = {"Smoke Test"}, priority = 2)
    public void userLogin() { // Assigned to Ayça / UserStory-2

        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);
        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();
        MyFunc.Wait(2);
        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys(validUsername);
        MyFunc.Wait(2);
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(validPassword);
        MyFunc.Wait(2);
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        submitButton.click();
        MyFunc.Wait(2);
        WebElement myAcc = driver.findElement(By.linkText("My account"));
        myAcc.click();
        MyFunc.Wait(2);
        WebElement eMailConfirm = driver.findElement(By.cssSelector("input[id='Email']"));
        Assert.assertTrue(validUsername.equals(eMailConfirm.getAttribute("value")));
    }

    @Test(dataProvider = "userData", groups = "Smoke Test", priority = 3)
    public void negativeLogin(String USERNAME, String PASSWORD) { // Assigned to İrem / UserStory-3

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.Mail));
        e.Mail.sendKeys(USERNAME);
        e.Password.sendKeys(PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(e.LOGIN));
        e.LOGIN.click();
        WebElement unsuccessful = driver.findElement(By.cssSelector("div[class='message-error validation-summary-errors']"));
        Assert.assertTrue(unsuccessful.getText().contains("Login was unsuccessful"));
    }

    @DataProvider
    public Object[][] userData() {

        Object[][] invalidData = {{validUsername, invalidPassword}, {invalidUsername, validPassword}, {invalidUsername, invalidPassword}};
        return invalidData;
    }

    @Test(dataProvider = "nullData", groups = "Smoke Test", priority = 4)
    public void nullLogin(String username, String password) { // Assigned to İrem / UserStory-3

        NopCommerce_POM e = new NopCommerce_POM();
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
    public Object[][] nullData() {
        Object[][] userNullData = {{validUsername, ""}, {"", validPassword}, {"", ""}};
        return userNullData;
    }

    @Test(groups = {"UI Test"}, priority = 5)
    public void tabMenuControl() { // Assigned to Serkan Özşahin / UserStory-4

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);
        List<String> tabMenuList = new ArrayList<>();
        Collections.addAll(tabMenuList, "Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards");
        for (int i = 0; i < e.tabMenuListCheck.size(); i++) {
            Assert.assertEquals(e.tabMenuListCheck.get(i).getText(), tabMenuList.get(i));
        }
    }

    @Test(groups = {"UI Test"}, priority = 6)
    public void tabMenuVerification() { // Assigned to Serkan Özşahin / UserStory-4

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);
        List<String> tabMenuList = new ArrayList<>();
        Collections.addAll(tabMenuList, "Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards");
        for (int i = 0; i < e.tabMenuListCheck.size(); i++) {
            WebElement tabMenuClick = driver.findElement(By.linkText(tabMenuList.get(i)));
            tabMenuClick.click();
            wait.until(ExpectedConditions.visibilityOf(e.textCheck));
            Assert.assertEquals(tabMenuList.get(i), e.textCheck.getText());
        }
    }

    @Test(groups = {"UI Test"}, priority = 7)
    public void tabMenuSubMenuVerification() { // Assigned to Serkan Özşahin / UserStory-4

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);
        Actions actions = new Actions(driver);
        List<String> tabMenuList = new ArrayList<>();
        Collections.addAll(tabMenuList, "Computers", "Electronics", "Apparel");
        List<String> subMenuListText = new ArrayList<>();
        Collections.addAll(subMenuListText, "Desktops", "Notebooks", "Software", "Camera & photo", "Cell phones", "Others", "Shoes", "Clothing", "Accessories");
        int index = 0;
        for (int i = 0; i < subMenuListText.size(); i++) {
            WebElement tabMenuClick = driver.findElement(By.linkText(tabMenuList.get(index)));
            Action action = actions.moveToElement(tabMenuClick).build();
            action.perform();
            WebElement subMenuClick = driver.findElement(By.linkText(subMenuListText.get(i)));
            subMenuClick.click();
            wait.until(ExpectedConditions.visibilityOf(e.subMenuTextCheck));
            Assert.assertEquals(subMenuListText.get(i), e.subMenuTextCheck.getText());
            if (i == 2 || i == 5) {
                index++;
            }
        }
    }

    @Test(groups = {"UI Test"}, priority = 8)
    public void giftOrder() { // Assigned to Serkan Şengül / UserStory-5

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        e.LoginButton.click();
        e.EmailName.sendKeys(validPassword);
        e.Password.sendKeys(validPassword);
        e.LoginClick.click();
        driver.navigate().back();
        e.GiftCardButton.click();
        int RandomGift = MyFunc.randomGenerator(e.AddCart.size());
        e.AddCart.get(RandomGift).click();
        e.RecipientName.sendKeys("Kerem");
        e.RecipientEmail.sendKeys("keremler212@gmail.com");
        e.Cart.click();
        e.ShoppingCart.click();
        String Confrim = e.ConfrimProduct.getText();
        Assert.assertTrue(e.ConfrimProduct.getText().equals(Confrim));
        System.out.println("Confrim = " + Confrim);
    }

    @Test(groups = {"UI Test"}, priority = 9)
    public void giftOrderNegative() { // Assigned to Serkan Şengül / UserStory-5

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        e.LoginButton.click();
        e.EmailName.sendKeys(validUsername);
        e.Password.sendKeys(validPassword);
        e.LoginClick.click();
        e.GiftCardButton.click();
        int RandomGift = MyFunc.randomGenerator(e.AddCart.size());
        e.AddCart.get(RandomGift).click();
        MyFunc.Wait(2);
        e.Cart.click();
        String ErrorMessage = e.WrongMessage.getText();
        Assert.assertTrue(e.WrongMessage.getText().equals(ErrorMessage));
        System.out.println("ErrorMessage = " + ErrorMessage);
    }

    @Test(groups = {"UI Test"}, priority = 10)
    public void computerOrder() {// Assigned to Serkan Şengül / UserStory-6

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        e.LoginButton.click();
        e.EmailName.sendKeys(validUsername);
        e.Password.sendKeys(validPassword);
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

    @Parameters("searchText")
    @Test(groups = {"UI Test"}, priority = 11)
    public void searchWithParameter(String search) {// Assigned to Serkan Özşahin / UserStory-7

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);
        e.searchBox.sendKeys(search + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(e.searchTextConfirm));
        Assert.assertEquals(search, e.productName.getText());
    }

    @Parameters("challengeText")
    @Test(priority = 12)
    public void tabMenuChallenge(String searchTxt) { // Challenge UserStory

        NopCommerce_POM e = new NopCommerce_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);
        Actions actions = new Actions(driver);
        List<String> allProducts = new ArrayList<>();
        List<String> tabMenuList = new ArrayList<>();
        Collections.addAll(tabMenuList, "Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards");
        List<String> subMenuListText = new ArrayList<>();
        Collections.addAll(subMenuListText, "Desktops", "Notebooks", "Software", "Camera & photo", "Cell phones", "Others", "Shoes", "Clothing", "Accessories");
        int index = 0;
        for (int i = 0; i < 13; i++) {
            if (index <= 2) {
                WebElement tabMenuClick = driver.findElement(By.linkText(tabMenuList.get(index)));
                Action action = actions.moveToElement(tabMenuClick).build();
                action.perform();
                WebElement subMenuClick = driver.findElement(By.linkText(subMenuListText.get(i)));
                subMenuClick.click();
            } else {
                WebElement tabMenuClick = driver.findElement(By.linkText(tabMenuList.get(index)));
                tabMenuClick.click();
            }
            for (WebElement name : e.productNames) {
                String productText = name.getText();
                allProducts.add(productText);
            }
            if (i == 2 || i == 5 || i >= 8) {
                index++;
            }
        }
        driver.navigate().to("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.visibilityOf(e.searchBox));
        e.searchBox.sendKeys(searchTxt + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(e.productName));
        Assert.assertTrue(allProducts.contains(e.productName.getText()));
    }
}

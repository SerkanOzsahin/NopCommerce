import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerkanOzsahin extends BaseDriver {

    @Test(groups = {"UI Test"})
    public void tabMenuControl() {

        SerkanOzsahin_POM e = new SerkanOzsahin_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        List<String> tabMenuList = new ArrayList<>();
        Collections.addAll(tabMenuList, "Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards");

        for (int i = 0; i < e.tabMenuListCheck.size(); i++) {

            Assert.assertEquals(e.tabMenuListCheck.get(i).getText(), tabMenuList.get(i));
        }
    }

    @Test(groups = {"UI Test"})
    public void tabMenuVerification() {

        SerkanOzsahin_POM e = new SerkanOzsahin_POM();
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

    @Test(groups = {"UI Test"})
    public void tabMenuSubMenuVerification() {

        SerkanOzsahin_POM e = new SerkanOzsahin_POM();
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

    @Test(groups = {"UI Test"})
    @Parameters("searchText")
    public void searchWithParameter(String search) {

        SerkanOzsahin_POM e = new SerkanOzsahin_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        e.searchBox.sendKeys(search + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(e.searchTextConfirm));
        Assert.assertEquals(search, e.productName.getText());
    }

    @Test
    @Parameters("challengeText")
    public void tabMenuChallenge(String search) {

        SerkanOzsahin_POM e = new SerkanOzsahin_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        Actions actions = new Actions(driver);

        List<String> tabMenuList = new ArrayList<>();
        Collections.addAll(tabMenuList, "Computers", "Electronics", "Apparel");

        List<String> subMenuListText = new ArrayList<>();
        Collections.addAll(subMenuListText, "Desktops", "Notebooks", "Software", "Camera & photo", "Cell phones", "Others", "Shoes", "Clothing", "Accessories");

        List<String> allProducts = new ArrayList<>();

        int index = 0;

        for (int i = 0; i < subMenuListText.size(); i++) {

            WebElement tabMenuClick = driver.findElement(By.linkText(tabMenuList.get(index)));
            Action action = actions.moveToElement(tabMenuClick).build();
            action.perform();
            WebElement subMenuClick = driver.findElement(By.linkText(subMenuListText.get(i)));
            subMenuClick.click();
            wait.until(ExpectedConditions.visibilityOf(e.subMenuTextCheck));

            for (WebElement products : e.allProductsText) {
                String productText = products.getText();
                allProducts.add(productText);
            }

            if (i == 2 || i == 5) {
                index++;
            }
        }

        driver.navigate().to("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.visibilityOf(e.searchBox));
        e.searchBox.sendKeys(search + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(e.productName));
        Assert.assertTrue(allProducts.contains(e.productName.getText()));
    }
}

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SerkanOzsahin extends BaseDriver {

    @Test
    public void tabMenuControl() {

        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(1);

        List<String> tabMenuList = new ArrayList<>();
        tabMenuList.add("Computers");
        tabMenuList.add("Electronics");
        tabMenuList.add("Apparel");
        tabMenuList.add("Digital downloads");
        tabMenuList.add("Books");
        tabMenuList.add("Jewelry");
        tabMenuList.add("Gift Cards");

        List<WebElement> tabMenuListCheck = driver.findElements(By.cssSelector("ul[class='top-menu notmobile'] > li"));

        for (int i = 0; i < tabMenuListCheck.size(); i++) {

            Assert.assertEquals(tabMenuListCheck.get(i).getText(), tabMenuList.get(i));
        }
    }

    @Test
    public void tabMenuControlVerification() {

        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(1);

        List<String> tabMenuList = new ArrayList<>();
        tabMenuList.add("Computers");
        tabMenuList.add("Electronics");
        tabMenuList.add("Apparel");
        tabMenuList.add("Digital downloads");
        tabMenuList.add("Books");
        tabMenuList.add("Jewelry");
        tabMenuList.add("Gift Cards");

        List<WebElement> tabMenuListCheck = driver.findElements(By.cssSelector("ul[class='top-menu notmobile'] > li"));

        for (int i = 0; i < tabMenuListCheck.size(); i++) {

            WebElement tabMenuClick = driver.findElement(By.linkText(tabMenuList.get(i)));
            tabMenuClick.click();
            WebElement textCheck = driver.findElement(By.cssSelector("div[class='page-title'] > h1"));
            Assert.assertEquals(tabMenuList.get(i), textCheck.getText());
            driver.navigate().back();
        }
    }
}

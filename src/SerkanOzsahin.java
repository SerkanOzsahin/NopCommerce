import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerkanOzsahin extends BaseDriver {

    @Test
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

    @Test
    public void tabMenuControlVerification() {

        SerkanOzsahin_POM e = new SerkanOzsahin_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        List<String> tabMenuList = new ArrayList<>();
        Collections.addAll(tabMenuList, "Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards");

        for (int i = 0; i < e.tabMenuListCheck.size(); i++) {

            WebElement tabMenuClick = driver.findElement(By.linkText(tabMenuList.get(i)));
            tabMenuClick.click();
            Assert.assertEquals(tabMenuList.get(i), e.textCheck.getText());
            driver.navigate().back();
        }
    }

    @Test
    public void tabMenuSubMenuLink() {

        SerkanOzsahin_POM e = new SerkanOzsahin_POM();
        driver.get("https://demo.nopcommerce.com/");
        MyFunc.Wait(2);

        for (WebElement link : e.subMenuList) {

            Assert.assertTrue(link.getTagName().contains("a"));
        }
    }

    @Test
    public void tabMenuSubMenu() {

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
            Assert.assertEquals(subMenuListText.get(i), e.subMenuTextCheck.getText());

            if (i == 2 || i == 5) {
                index++;
            }
        }
    }
}

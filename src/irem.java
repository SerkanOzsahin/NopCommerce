import Utility.BaseDriver;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class irem extends BaseDriver {
    String mail1 = "iremt8202@gmail.com";
    String password1 = "fhfrnf45689";
    String mail2 = "iremmmfhh@gmail.com";
    String mail3 = "";
    String password2 = "gtfeggh123AB";
    String password3 = "";

    @Test
    public void NegativeAndPositiveLogin() {
        iremPOM e = new iremPOM();
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Login));
        e.Login.click();



    }

}

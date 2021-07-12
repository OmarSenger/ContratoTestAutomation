package SignUp;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;

public class SignUpTests extends BaseTest {
    @Test
    public void fillSignUp(){
        LoginPage loginPage = new LoginPage(driver);
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        driver.get("https://thecontrato.com/ar/login");
        WebElement checkBox = (WebElement) javascript.executeScript("return driver.findElement(By.id('AgreeConditions'));");
        checkBox.click();
//        javascript.executeScript("\'"+checkBox+"\'");
//        WebDriverWait wait = new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("AgreeConditions")));
        loginPage.signUp("Omar","aaa@gmail.com","01068938850","0124047218","0124047218");
    }
}

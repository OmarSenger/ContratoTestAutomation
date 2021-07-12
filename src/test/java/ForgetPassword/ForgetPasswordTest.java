package ForgetPassword;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ForgetPasswordPage;
import pages.LoginPage;
import pages.RecreatePasswordPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;

public class ForgetPasswordTest extends BaseTest {

    @Test
    public void incorrectEmailAddress(){
        ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.accessLoginPage();
        loginPage.accessForgetPasswordPage();
        forgetPasswordPage.setEmailField("asd");
        forgetPasswordPage.clickOnSendButton();
        String wrongEmailError = driver.findElement(By.id("validation-email")).getText();
        assertEquals("الرجاء ادخال بريد الكترونى صحيح",wrongEmailError);
    }
    @Test
    public void emptyEmailField(){
        ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.accessLoginPage();
        loginPage.accessForgetPasswordPage();
        forgetPasswordPage.setEmailField("");
        forgetPasswordPage.clickOnSendButton();
        String wrongEmailError = driver.findElement(By.id("validation-email")).getText();
        assertEquals("الرجاء ادخال بريد الكترونى",wrongEmailError);
    }
    @Test
    public void noExistEmail(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.accessLoginPage();
        loginPage.accessForgetPasswordPage();
        forgetPasswordPage.setEmailField("oo@contrato.com");
        forgetPasswordPage.clickOnSendButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("validation-email"))));
        String wrongEmailError = driver.findElement(By.id("validation-email")).getText();
        assertEquals("بريد إلكترونى غير موجود",wrongEmailError);
    }
    @Test
    public RecreatePasswordPage successSendingMail(){
        ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.accessLoginPage();
        loginPage.accessForgetPasswordPage();
        forgetPasswordPage.setEmailField("osenger@barek.com");
        forgetPasswordPage.clickOnSendButton();
        return new RecreatePasswordPage(driver);
    }
}

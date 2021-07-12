package Login;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
public class LoginTest extends BaseTest {

    @Test
    public void LoginPageAccess(){
            LoginPage loginPage = landingPage.clickOnLandingLoginButton();
            String loginUrl = loginPage.getLoginPageUrl();
            assertEquals("https://thecontrato.com/ar/login",loginUrl);
    }
    @Test(priority = 1)
    public void checkingValidation(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://thecontrato.com/ar/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.clickOnLoginButton();
        String text = driver.findElement(By.cssSelector("body > div.content > div > div:nth-child(2) > div > section > div > div.signin-content > div.signin-form > h2")).getText();
        System.out.println(text);
        //أستخدم Assertions
    }
    @Test(priority = 2)
    public void ValidUserWithInvalidPassword(){
        driver.get("https://thecontrato.com/ar/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailField("osenger@barek.net");
        loginPage.setPassField("123456789");
        loginPage.clickOnLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getCurrentUrl());
        // أستخدم Assertions
    }
    @Test(priority = 3)
    public void securedPassword(){
        String passwordType = driver.findElement(By.className("login-password")).getAttribute("type");
        assertEquals("password",passwordType);
    }
    @Test(priority = 4)
    public void accessForgetPassword(){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.accessForgetPasswordPage();
            String forgetPasswordUrl = driver.getCurrentUrl();
            assertEquals("https://thecontrato.com/ar/Account/ForgetPwd",forgetPasswordUrl);
    }
    @Test(priority = 5)
    public void successLogin(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://thecontrato.com/ar/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.setEmailField("osenger@barek.net");
        loginPage.setPassField("123456");
        loginPage.clickOnLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getCurrentUrl());
    }

}

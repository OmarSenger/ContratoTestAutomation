package ContactUs;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;

public class ContactUsTest extends BaseTest {
    @Test
    public void accessPage(){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.accessContactUsPage();
        String url = driver.getCurrentUrl();
        assertEquals("https://thecontrato.com/ar/contactus",url);
    }
    @Test
    public void noData (){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        driver.get("https://thecontrato.com/ar/contactus");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        contactUsPage.clickOnSendButton();
    }
    @Test
    public void wrongEmailFormat(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        driver.get("https://thecontrato.com/ar/contactus");
        contactUsPage.msgData("Omar","Omar","QC","01068938890","Testing Wrong Email Format !");
        contactUsPage.clickOnSendButton();
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='Email' and @class='form-control']"))));
        element.getText();
    }
    @Test
    public void accessFacebookPage(){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        driver.get("https://thecontrato.com/ar/contactus");
        contactUsPage.accessFacebook();
    }
    @Test
    public void accessInstaPage(){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        driver.get("https://thecontrato.com/ar/contactus");
        contactUsPage.accessInsta();
    }
    @Test
    public void accessLinkedInPage(){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        driver.get("https://thecontrato.com/ar/contactus");
        contactUsPage.accessLinkedIn();
    }
    @Test
    public void sendMessage(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        driver.get("https://thecontrato.com/ar/contactus");
        String winHandleBefore = driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().window(winHandleBefore);
        contactUsPage.msgData("OmarSenger","osenger@barek.net","QC","01068938890","Automation Testing For Contact Us Page !");
        contactUsPage.clickOnSendButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sendmessage"))));
        String successMsg = driver.findElement(By.id("sendmessage")).getText();
        assertEquals("تم ارسال رسالتك . شكرا لك !",successMsg);
    }
}

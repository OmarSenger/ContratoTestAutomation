package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver;
    public ContactUsPage(WebDriver driver){
        this.driver = driver ;
    }
    private By contactUsLink = By.linkText("تواصل معنا");
    private By name = By.id("name");
    private By email = By.id("Email");
    private By title = By.id("Title");
    private By phone = By.id("Phone");
    private By msg = By.id("Msg");
    private By sendButton = By.xpath("//button[@type='submit']");
    private By facebook = By.xpath("/html/body/section/div/div/div[2]/div[1]/div[1]/a[3]");
    private By insta = By.xpath("/html/body/section/div/div/div[2]/div[1]/div[1]/a[2]");
    private By linkedin = By.xpath("/html/body/section/div/div/div[2]/div[1]/div[1]/a[1]");

    public void accessContactUsPage(){
        driver.findElement(contactUsLink).click();
    }
    public void clickOnSendButton(){
        driver.findElement(sendButton).click();
    }
    public void msgData(String Name , String Email , String Title , String Phone , String Msg){
        driver.findElement(name).sendKeys(Name);
        driver.findElement(email).sendKeys(Email);
        driver.findElement(title).sendKeys(Title);
        driver.findElement(phone).sendKeys(Phone);
        driver.findElement(msg).sendKeys(Msg);
    }
    public void accessFacebook(){
        driver.findElement(facebook).click();
    }
    public void accessInsta(){
        driver.findElement(insta).click();
    }
    public void accessLinkedIn(){
        driver.findElement(linkedin).click();
    }
}

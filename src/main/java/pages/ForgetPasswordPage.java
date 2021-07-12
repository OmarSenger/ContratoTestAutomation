package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage {
    private WebDriver driver;
    public ForgetPasswordPage(WebDriver driver){
        this.driver = driver ;
    }
    private By emailField = By.id("email");
    private By sendButton = By.id("send");

    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void clickOnSendButton(){
        driver.findElement(sendButton).click();
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver ;
    }
    private By landingLoginButton = By.linkText("تسجيل الدخول");
    public LoginPage clickOnLandingLoginButton(){
        driver.findElement(landingLoginButton).click();
        return new LoginPage(driver);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecreatePasswordPage {
    private WebDriver driver;
    public RecreatePasswordPage(WebDriver driver){
        this.driver = driver ;
    }
    private By emailField = By.id("Email");
    private By codeField = By.id("Code");
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver ;
    }
    private By emailField = By.className("login-email");
    private By passField = By.className("login-password");
    private By loginButton = By.id("signin");
    private By forgetPassword = By.linkText("لا اتذكر كلمة السر");
    private By userName = By.className("signup-user");
    private By signUpMail = By.className("signup-email");
    private By signUpPhone = By.className("signup-phone");
    private By signUpPass = By.className("signup-password");
    private By confirmSignUpPass = By.className("signup-confirmpassword");
    private By createButton = By.id("signup");
    private By checkBox = By.id("AgreeConditions");


    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassField(String password){
        driver.findElement(passField).sendKeys(password);
    }

    public void accessLoginPage(){
        driver.get("https://thecontrato.com/ar/login");
    }

    public String getLoginPageUrl(){
        return driver.getCurrentUrl();
    }
    public HomePage clickOnLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage (driver);
    }
    public ForgetPasswordPage accessForgetPasswordPage(){
        driver.findElement(forgetPassword).click();
        return new ForgetPasswordPage(driver);
    }
    public void signUp(String username , String mail , String phone , String pass , String confirmPass){
       driver.findElement(userName).sendKeys(username);
       driver.findElement(signUpMail).sendKeys(mail);
       driver.findElement(signUpPhone).sendKeys(phone);
       driver.findElement(signUpPass).sendKeys(pass);
       driver.findElement(confirmSignUpPass).sendKeys(confirmPass);
//       driver.findElement(checkBox).click();
       driver.findElement(createButton).click();
        }
}

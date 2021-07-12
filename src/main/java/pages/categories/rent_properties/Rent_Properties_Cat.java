package pages.categories.rent_properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class Rent_Properties_Cat {
    private WebDriver driver;
    public Rent_Properties_Cat(WebDriver driver){
        this.driver = driver ;
    }
    private By rentPropertiesCategory = By.className("it-cat-1028");
    private By leaseOfApartmentContract = By.className("it-cat-1109");
    private By createLeaseOfApartmentContract = By.linkText("انشاء العقد");

    public void successLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.accessLoginPage();
        loginPage.setEmailField("osenger@barek.net");
        loginPage.setPassField("123456");
        loginPage.clickOnLoginButton();
    }

    public void openRentPropertiesCategory(){
        driver.findElement(rentPropertiesCategory).click();
    }
    public void setCreateLeaseOfApartmentContract(){
        driver.findElement(leaseOfApartmentContract).click();
        driver.findElement(createLeaseOfApartmentContract).click();
    }
}

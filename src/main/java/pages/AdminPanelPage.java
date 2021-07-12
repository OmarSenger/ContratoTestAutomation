package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AdminPanelPage {
    private WebDriver driver;
    public AdminPanelPage(WebDriver driver){
        this.driver = driver ;
    }

    private By langChanger = By.id("ArButton");
    private By logout = By.className("enArbtn");
    private By optionList = By.className("caret");
    private By contracts = By.id("Contracts");
    private By addNewContButton = By.className("pull-right");
    private By contractEnglishName = By.id("NameEn");
    private By contractArabicName = By.id("NameAr");
    private By status = By.id("Status");
    private By rank = By.id("rank");
    private By categorySection = By.className("select2-selection__rendered");
    private By category = By.xpath("/html/body/span/span/span/ul/li[1]");
    private By addButton = By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/div/div/div[3]/button[1]");


    public void loginToAdmin(){
       LoginPage loginPage = new LoginPage(driver);
        loginPage.accessLoginPage();
        loginPage.setEmailField("AdminGoContracts@GoContracts.com");
        loginPage.setPassField("zXS#$QR?!4S&9rY");
        loginPage.clickOnLoginButton();
    }

    public void langChanger (){
        driver.findElement(langChanger).click();
    }
    public void logoutFromAdminPanel (){
        driver.findElement(logout).click();
    }
    public void addNewContract(String englishName , String arabicName , String Rank){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(optionList)));
        driver.findElements(optionList).get(0).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(contracts).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addNewContButton)));
        driver.findElement(addNewContButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(contractEnglishName).sendKeys(englishName);
        driver.findElement(contractArabicName).sendKeys(arabicName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(categorySection).click();
        driver.findElement(category).click();
        Select selectStatus = new Select(driver.findElement(status));
        selectStatus.selectByIndex(2);
        driver.findElement(rank).sendKeys(Rank);
        driver.findElement(addButton).click();
    }

}

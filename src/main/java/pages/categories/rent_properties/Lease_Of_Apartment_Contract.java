package pages.categories.rent_properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Lease_Of_Apartment_Contract {
    private WebDriver driver;
    public Lease_Of_Apartment_Contract(WebDriver driver){
        this.driver = driver ;
    }
    private By contractDate = By.className("fa-calendar");
    private By pickDay = By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top > div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(4)");
    private By firstPartyGender = By.className("value_78300");
    private By secPartyGender = By.className("value_78295");
    private By nextButton = By.className("btnNext");
//    private By preButton = By.className("btnPrevious");
    private By newPart = By.linkText("اضافة طرف جديد");
    private By extraPartID = By.id("PartnerId");
    private By extraPartNewName = By.className("valAr_834");
    private By extraPartName = By.className("valAr_835");
    private By extraPartNationalID = By.className("valAr_836");
    private By saveButton = By.className("btnsaveclosesuccess");
    private By okButton = By.className("swal2-confirm");
    private By textInput = By.className("textEntered");
    // firstBand
    private By firstBandNextButton = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/a[1]");
    // 2ndBand
    private By secBandNextButton = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/a[1]");

    public void createParts(String extraPartyNewName , String extraPartyName , String extraPartyNationalID ){
        WebDriverWait wait = new WebDriverWait(driver,30);
        int [] fields = {1,2,3,4,5,6,7,8,9};
        // Extra Party Data
        driver.findElement(newPart).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(extraPartID).click();
        Select selectExtraPartID = new Select(driver.findElement(extraPartID));
        selectExtraPartID.selectByIndex(2);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(extraPartNewName).sendKeys(extraPartyNewName);
        driver.findElement(extraPartName).sendKeys(extraPartyName);
        driver.findElement(extraPartNationalID).sendKeys(extraPartyNationalID);
        driver.findElement(saveButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(okButton).click();
        driver.findElement(contractDate).click();
        driver.findElement(pickDay).click();
        Select selectFirstPartyGender =new Select(driver.findElement(firstPartyGender));
        selectFirstPartyGender.selectByValue("أنثى");
        Select selectSecPartyGender =new Select(driver.findElement(secPartyGender));
        selectSecPartyGender.selectByValue("ذكر");

        for (int j : fields) {
            if (driver.findElements(textInput).get(j).getAttribute("class").contains("number") || driver.findElements(textInput).get(j).getAttribute("data-code").contains("@FirstpartynationalidentificationnumberCode")) {
                driver.findElements(textInput).get(j).sendKeys("12345678912345");
            } else if(driver.findElements(textInput).get(j).getAttribute("data-code").contains("@SecondpartynationalidentificationnumberCode")) {
                driver.findElements(textInput).get(j).sendKeys("22345678912345");
            }else {
                driver.findElements(textInput).get(j).sendKeys("داتا");
            }
        }
        driver.findElement(nextButton).click();
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
    }
    public void createFirstBand(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        int [] fields = {10,11,12,13,14,15,16};
        for (int j : fields) {
            if (driver.findElements(textInput).get(j).getAttribute("class").contains("number")) {
                driver.findElements(textInput).get(j).sendKeys("12345678912345");
            } else {
                driver.findElements(textInput).get(j).sendKeys("داتا");
            }
        }
        driver.findElement(firstBandNextButton).click();
    }
    public void createSecBand(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        int [] fields = {17};
        for (int j : fields) {
            if (driver.findElements(textInput).get(j).getAttribute("class").contains("number")) {
                driver.findElements(textInput).get(j).sendKeys("12345678912345");
            } else {
                driver.findElements(textInput).get(j).sendKeys("داتا");
            }
        }
        driver.findElement(secBandNextButton).click();
    }
}

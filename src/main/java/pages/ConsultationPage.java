package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConsultationPage {
    private WebDriver driver;
    public ConsultationPage(WebDriver driver){
        this.driver = driver ;
    }
    private By consultation = By.xpath("/html/body/header[1]/div/nav/ul/li[2]/a");

    public void accessConsultationPage(){
        driver.findElement(consultation).click();
    }
}

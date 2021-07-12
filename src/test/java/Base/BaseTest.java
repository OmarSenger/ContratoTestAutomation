package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LandingPage;

public class BaseTest {
public WebDriver driver ;
protected LandingPage landingPage ;
@BeforeClass
public void setUp (){
    System.setProperty("webdriver.chrome.driver", "C://Users//lenovo//Downloads//chromedriver2.exe");
    driver = new ChromeDriver();
    driver.get("https://thecontrato.com/ar");
    driver.manage().window().maximize();
    landingPage = new LandingPage(driver);
}
//    @AfterClass
//    public void tearDown(){
//    driver.quit();
//    }
}

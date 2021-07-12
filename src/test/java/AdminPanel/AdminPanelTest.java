package AdminPanel;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AdminPanelPage;
import pages.LoginPage;

import static org.testng.Assert.*;
public class AdminPanelTest extends BaseTest {
    @Test
    public void dashboardCounters(){
        driver.manage().deleteAllCookies();
        int [] option = {0,1,2,3,4};
        LoginPage loginPage = new LoginPage(driver);
        loginPage.accessLoginPage();
        loginPage.setEmailField("AdminGoContracts@GoContracts.com");
        loginPage.setPassField("zXS#$QR?!4S&9rY");
        loginPage.clickOnLoginButton();
        driver.get("https://thecontrato.com/Office/Home/Dashboard");
        for (int i = 0 ; i< option.length ; i++){
            String category = driver.findElements(By.className("card-category")).get(option[i]).getText();
            String content = driver.findElements(By.className("card-title")).get(option[i]).getText();
            System.out.println(content+"/"+category);
        }
    }

    @Test
    public void addNewContract(){

        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.loginToAdmin();
        adminPanelPage.addNewContract("Contract Test","إختبار عقد" , "1" );
    }
}

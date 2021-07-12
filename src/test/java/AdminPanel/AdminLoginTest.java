package AdminPanel;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AdminPanelPage;
import pages.LoginPage;

import static org.testng.Assert.*;

public class AdminLoginTest extends BaseTest {
    @Test
    public void loginAsAdmin(){
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.loginToAdmin();
        String adminPanelUrl = driver.getCurrentUrl();
        assertEquals("https://thecontrato.com/Office/Home/Dashboard",adminPanelUrl);
        adminPanelPage.langChanger();
        String logoutButtonText = driver.findElement(By.className("enArbtn")).getText();
        assertEquals("LOGOUT",logoutButtonText);
    }
    @Test
    public void logoutFromAdminPanel(){
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.logoutFromAdminPanel();
        String loginUrl = driver.getCurrentUrl();
        assertEquals("https://thecontrato.com/en/login",loginUrl);
    }
}

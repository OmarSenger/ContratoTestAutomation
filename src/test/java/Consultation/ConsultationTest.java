package Consultation;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.ConsultationPage;

import static org.testng.Assert.assertEquals;

public class ConsultationTest extends BaseTest {
    @Test
    public void accessPage(){
        ConsultationPage consultationPage = new ConsultationPage(driver);
        consultationPage.accessConsultationPage();
        String consultationUrl = driver.getCurrentUrl();
        assertEquals("https://thecontrato.com/ar/Lawyers",consultationUrl);
    }
    @Test
    public void chooseLawyer(){

    }
}

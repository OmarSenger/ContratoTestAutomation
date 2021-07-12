package Categories.Rent_Properties_Contracts_Test;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.categories.rent_properties.Lease_Of_Apartment_Contract;
import pages.categories.rent_properties.Rent_Properties_Cat;

import java.util.concurrent.TimeUnit;

public class Lease_of_apartment_contract_test extends BaseTest {
@Test
    public void createParts(){
    Rent_Properties_Cat rent_propertiesCat = new Rent_Properties_Cat(driver);
    rent_propertiesCat.successLogin();
    rent_propertiesCat.openRentPropertiesCategory();
    rent_propertiesCat.setCreateLeaseOfApartmentContract();
    Lease_Of_Apartment_Contract lease_of_apartment_contract = new Lease_Of_Apartment_Contract(driver);
    lease_of_apartment_contract.createParts("طرف ثالث", "عمر","12345678912312");
}
@Test(priority = 1)
    public void createFirstBand(){
    Lease_Of_Apartment_Contract lease_of_apartment_contract = new Lease_Of_Apartment_Contract(driver);
    lease_of_apartment_contract.createFirstBand();
}
    @Test(priority = 2)
    public void createSecBand(){
        Lease_Of_Apartment_Contract lease_of_apartment_contract = new Lease_Of_Apartment_Contract(driver);
        lease_of_apartment_contract.createSecBand();
    }
}

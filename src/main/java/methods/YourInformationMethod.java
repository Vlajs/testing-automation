package methods;

import org.openqa.selenium.WebDriver;
import pages.YourInformationPage;

public class YourInformationMethod extends YourInformationPage {
    public YourInformationMethod(WebDriver driver) {
        super(driver);
    }
    public void enterYourInformation(String firstName, String lastName, String postalCode){
        writeFirstName(firstName);
        writeLastName(lastName);
        writePostalCode(postalCode);
        clickOnContinueButton();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourInformationPage extends BasePage{
    public YourInformationPage(WebDriver driver) {
        super(driver);
    }
    By firstNameFieldBy = By.id("first-name");
    By lastNameFieldBy = By.id("last-name");
    By postalCodeBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
    public void writeFirstName(String firstName){
        writeText(firstNameFieldBy, firstName);
    }
    public void writeLastName(String lastName){
        writeText(lastNameFieldBy, lastName);
    }
    public void writePostalCode(String postalCode){
        writeText(postalCodeBy, postalCode);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButtonBy);
    }
}

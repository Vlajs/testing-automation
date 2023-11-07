package methods;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginMethod extends LoginPage {
    public LoginMethod(WebDriver driver) {
        super(driver);
    }
    public void performLogin(String usernameText, String passwordText){
        writeUsername(usernameText);
        writePassword(passwordText);
        clickOnLogInButton();
    }
    public void performFailedLogin(String usernameText, String passwordText, String expectedText){
        writeUsername(usernameText);
        writePassword(passwordText);
        clickOnLogInButton();
        verifyFailedLogin(expectedText);
    }
}

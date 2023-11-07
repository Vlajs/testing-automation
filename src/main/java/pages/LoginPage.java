package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By usernameFieldBy = By.id("user-name");
    By passwordFieldBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorMesaggeBy = By.xpath("//h3[@data-test='error']");
    public void writeUsername(String usernameText){
        writeText(usernameFieldBy, usernameText);
    }
    public void writePassword(String passwordText){
        writeText(passwordFieldBy, passwordText);
    }
    public void clickOnLogInButton(){
        clickOnElement(loginButtonBy);
    }
    public void verifyFailedLogin(String expectedText){
        Assert.assertEquals(readText(errorMesaggeBy), expectedText);
    }
    public void verifyLogout(String attribute, String expectedText){
        Assert.assertEquals(readAttribute(loginButtonBy, attribute), expectedText);
    }
}

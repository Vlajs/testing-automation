package tests;

import dataProviders.DataProvider;
import methods.LoginMethod;
import org.testng.annotations.Test;

public class FailedLogInTest extends BaseTest{
    @Test(dataProvider = "FailedLoginSet", dataProviderClass = DataProvider.class)
    public void failedLogIn(String username, String password, String verifyMessage) {
        LoginMethod loginMethod = new LoginMethod(driver);
        loginMethod.performFailedLogin(username, password, verifyMessage);
    }
}

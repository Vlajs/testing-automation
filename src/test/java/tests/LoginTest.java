package tests;

import dataProviders.DataProvider;
import methods.HomePageMethod;
import methods.LoginMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test(dataProvider = "LoginSet", dataProviderClass = DataProvider.class)
    public void loginTest(String username, String password, String verifyMessage){
        LoginMethod loginMethod = new LoginMethod(driver);
        loginMethod.performLogin(username, password);
        HomePageMethod homePageMethod = new HomePageMethod(driver);
        homePageMethod.verifyLogin(verifyMessage);
    }
}

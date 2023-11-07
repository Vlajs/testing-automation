package testWithLogin;

import methods.HomePageMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LogoutTest extends BaseTestWithLogin{
    @Test
    public void logoutTest(){
        HomePageMethod homePageMethod = new HomePageMethod(driver);
        homePageMethod.performLogout();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLogout("value","Login");
    }
}

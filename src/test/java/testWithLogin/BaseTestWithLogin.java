package testWithLogin;

import methods.LoginMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import property.PropertyManager;
import tests.BaseTest;

public class BaseTestWithLogin extends BaseTest {
    @Override
    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser){
        super.setUp(browser);
        LoginMethod loginMethod = new LoginMethod(driver);
        loginMethod.performLogin(PropertyManager.getInstance().getValidUsername(), PropertyManager.getInstance().getValidPassword());
    }
}

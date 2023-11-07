package testWithLogin;

import methods.HomePageMethod;
import methods.ShoppingCartContainerMethod;
import org.testng.annotations.Test;

public class AddTwoRandomElementTest extends BaseTestWithLogin{
    @Test
    public void addTwoRandomElement() {
        HomePageMethod homePageMethod = new HomePageMethod(driver);
        String[] textFromTwoRandomItems = homePageMethod.performAddTwoRandomItems();
        homePageMethod.openShoppingCartContainer();
        ShoppingCartContainerMethod shoppingCartContainerMethod = new ShoppingCartContainerMethod(driver);
        shoppingCartContainerMethod.verifyTwoRandomItems(textFromTwoRandomItems[0], textFromTwoRandomItems[1]);
    }
}

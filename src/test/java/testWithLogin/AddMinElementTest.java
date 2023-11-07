package testWithLogin;

import methods.HomePageMethod;
import methods.ShoppingCartContainerMethod;
import org.testng.annotations.Test;

public class AddMinElementTest extends BaseTestWithLogin{
    @Test
    public void addMinElement() {
        HomePageMethod homePageMethod = new HomePageMethod(driver);
        String textFromMinElement = homePageMethod.performAddMinItem();
        homePageMethod.openShoppingCartContainer();
        ShoppingCartContainerMethod shoppingCartContainerMethod = new ShoppingCartContainerMethod(driver);
        shoppingCartContainerMethod.verifyPriceFromItem(textFromMinElement);
    }
}

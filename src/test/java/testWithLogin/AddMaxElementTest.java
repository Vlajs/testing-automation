package testWithLogin;

import methods.HomePageMethod;
import methods.ShoppingCartContainerMethod;
import org.testng.annotations.Test;

public class AddMaxElementTest extends BaseTestWithLogin{
    @Test
    public void addMaxElement() {
        HomePageMethod homePageMethod = new HomePageMethod(driver);
        String maxPrice = homePageMethod.performAddMaxItem();
        homePageMethod.openShoppingCartContainer();
        ShoppingCartContainerMethod shoppingCartContainerMethod = new ShoppingCartContainerMethod(driver);
        shoppingCartContainerMethod.verifyPriceFromItem(maxPrice);
    }
}

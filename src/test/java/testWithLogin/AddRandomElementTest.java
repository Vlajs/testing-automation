package testWithLogin;

import methods.HomePageMethod;
import methods.ShoppingCartContainerMethod;
import org.testng.annotations.Test;

public class AddRandomElementTest extends BaseTestWithLogin{
    @Test
    public void addRandomItemToCart() {
        HomePageMethod homePageMethod = new HomePageMethod(driver);
        String textFromRandomItem = homePageMethod.performAddRandomItem();
        homePageMethod.openShoppingCartContainer();
        ShoppingCartContainerMethod shoppingCartContainerMethod = new ShoppingCartContainerMethod(driver);
        shoppingCartContainerMethod.verifyNameFromItem(textFromRandomItem);
    }
}

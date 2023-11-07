package testWithLogin;

import faker.Faker;
import methods.*;
import org.testng.annotations.Test;

public class AddElementTest extends BaseTestWithLogin{
    @Test
    public void addToItemToCart(){
        HomePageMethod homePageMethod = new HomePageMethod(driver);
        homePageMethod.performAddToCartItem();
        ShoppingCartContainerMethod shoppingCartContainerMethod = new ShoppingCartContainerMethod(driver);
        shoppingCartContainerMethod.verifyAddToCart("Your Cart", "Sauce Labs Backpack");
        shoppingCartContainerMethod.clickOnCheckoutButton();
        YourInformationMethod yourInformationMethod = new YourInformationMethod(driver);
        yourInformationMethod.enterYourInformation(Faker.fakeFirstName(), Faker.fakeLastName(), Faker.fakePostalCode());
        OverviewMethod overviewMethod = new OverviewMethod(driver);
        overviewMethod.verifyOverview(29.99);
        overviewMethod.clickOnFinishButton();
        CompleteMethod completeMethod = new CompleteMethod(driver);
        completeMethod.verifyShopping("Thank you for your order!");
    }
}

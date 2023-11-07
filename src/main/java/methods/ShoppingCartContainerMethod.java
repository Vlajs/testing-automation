package methods;

import org.openqa.selenium.WebDriver;
import pages.ShoppingCartContainer;

public class ShoppingCartContainerMethod extends ShoppingCartContainer {
    public ShoppingCartContainerMethod(WebDriver driver) {
        super(driver);
    }
    public void verifyAddToCart(String expectedTextForYourCart, String expectedTextForItemName){
        verifyAddToCartItem(expectedTextForYourCart, expectedTextForItemName);
    }
    public void clickOnCheckout(){
        clickOnCheckoutButton();
    }
    public void verifyPriceFromItem(String expectedText){
        verifyPriceFromItemToCart(expectedText);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ShoppingCartContainer extends BasePage{
    public ShoppingCartContainer(WebDriver driver) {
        super(driver);
    }
    By yourCartLabelBy = By.className("title");
    By itemNameBy = By.className("inventory_item_name");
    By checkoutButtonBy = By.id("checkout");
    By allPriceFromElementBy = By.className("inventory_item_price");
    By allCartItemBy = By.className("cart_item");
    public void verifyAddToCartItem(String expectedTextForYourCart, String expectedTextForItemName){
        Assert.assertEquals(readText(yourCartLabelBy), expectedTextForYourCart);
        Assert.assertEquals(readText(itemNameBy), expectedTextForItemName);
    }
    public void clickOnCheckoutButton(){
        clickOnElement(checkoutButtonBy);
    }
    public void verifyPriceFromItemToCart(String expectedText){
        Assert.assertEquals(readText(allPriceFromElementBy), expectedText);
    }
    public void verifyNameFromItem(String expectedText){
        Assert.assertEquals(readText(itemNameBy), expectedText);
    }
    public void verifyTwoRandomItems(String firstExpectedText, String secondExpectedText){
        List<WebElement> list = driver.findElements(allCartItemBy);
        Assert.assertEquals((list.get(0).findElement(itemNameBy).getText()), firstExpectedText);
        Assert.assertEquals((list.get(1).findElement(itemNameBy).getText()), secondExpectedText);
    }
}

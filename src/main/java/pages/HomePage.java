package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By productsLabelBy = By.xpath("//span[@class='title']");
    By burgerButtonMenuBy = By.className("bm-burger-button");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By backpackItemBy = By.id("add-to-cart-sauce-labs-backpack");
    By shoppingCartContainerBy = By.id("shopping_cart_container");
    By allInventoryItemBy = By.className("inventory_item");
    By allInventoryItemPriceBy = By.className("inventory_item_price");
    By allAddToCartButtonBy = By.tagName("button");
    By getAllInventoryItemNameBy = By.className("inventory_item_name");
    public void verifyLogin(String expectedText){
        Assert.assertEquals(readText(productsLabelBy), expectedText);
    }
    public void clickOnBurgerButtonMenu(){
        clickOnElement(burgerButtonMenuBy);
    }
    public void clickOnLogoutButton(){
        clickOnElement(logoutButtonBy);
    }
    public void clickOnBackpackItem(){
        clickOnElement(backpackItemBy);
    }
    public void openShoppingCartContainer(){
        clickOnElement(shoppingCartContainerBy);
    }
    public WebElement addMaxElementToCart(){
        return maxElement(allInventoryItemBy, allInventoryItemPriceBy);
    }
    public String getPriceFromElement(WebElement maxElement){
        return maxElement.findElement(allInventoryItemPriceBy).getText();
    }
    public WebElement clickOnAddToCartButton(WebElement element){
        element.findElement(allAddToCartButtonBy).click();
        return element;
    }
    public WebElement getRandomElement(){
        return randomElement(allInventoryItemBy);
    }
    public String getNameFromElement(WebElement element){
        return element.findElement(getAllInventoryItemNameBy).getText();
    }
    public WebElement addMinElementToCart(){
        return minElement(allInventoryItemBy, allInventoryItemPriceBy);
    }
}

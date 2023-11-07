package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;

public class HomePageMethod extends HomePage {
    public HomePageMethod(WebDriver driver) {
        super(driver);
    }
    public void performLoginVerification(String expectedText){
        verifyLogin(expectedText);
    }
    public void performLogout(){
        clickOnBurgerButtonMenu();
        clickOnLogoutButton();
    }
    public void performAddToCartItem(){
        clickOnBackpackItem();
        openShoppingCartContainer();
    }
    public String  performAddMaxItem(){
        return getPriceFromElement(clickOnAddToCartButton(addMaxElementToCart()));
    }
    public String performAddMinItem(){
        return getPriceFromElement(clickOnAddToCartButton(addMinElementToCart()));
    }
    public String performAddRandomItem(){
        return getNameFromElement(clickOnAddToCartButton(getRandomElement()));
    }
    public String[] performAddTwoRandomItems(){
        WebElement firstElement = getRandomElement();
        WebElement secondElement = getRandomElement();
        String textFromFirstElement = getNameFromElement(firstElement);
        String textFromSecondElement = getNameFromElement(secondElement);
        while (textFromFirstElement.equals(textFromSecondElement)){
            secondElement = getRandomElement();
            textFromSecondElement = getNameFromElement(secondElement);
        }
        clickOnAddToCartButton(firstElement);
        clickOnAddToCartButton(secondElement);
        return new String[]{textFromFirstElement, textFromSecondElement};
    }
}

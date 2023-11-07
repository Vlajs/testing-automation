package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OverviewPage extends BasePage{
    public OverviewPage(WebDriver driver) {
        super(driver);
    }
    By inverntoryItemPriceBy = By.xpath("//div[@class='inventory_item_price']");
    By finishButtonBy = By.id("finish");
    public double getPriceFromInventoryItem(){
        return getPriceFromElement(inverntoryItemPriceBy);
    }
    public void verifyInventoryItemPrice(double expectedPriceFromInventoryItem){
        Assert.assertEquals(getPriceFromInventoryItem(), expectedPriceFromInventoryItem);
    }
    public void clickOnFinishButton(){
        clickOnElement(finishButtonBy);
    }

}

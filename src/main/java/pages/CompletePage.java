package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompletePage extends BasePage{
    public CompletePage(WebDriver driver) {
        super(driver);
    }
    By finishTextFieldBy = By.xpath("//h2[@class='complete-header']");
    public void verifyCompleteShopping(String expectedText){
        Assert.assertEquals(readText(finishTextFieldBy), expectedText);
    }
}

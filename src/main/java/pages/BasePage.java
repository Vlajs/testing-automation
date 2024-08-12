package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public void waitVisibility(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void clickOnElement(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
    public void hoverOnElement(By elementBy){
        waitVisibility(elementBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(elementBy)).click().build().perform();
    }
    public WebElement byToWebElement(By elementBy){
        return driver.findElement(elementBy);
    }
    public void writeText(By elementBy, String expectedText){
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(expectedText);
    }
    public String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
    public String readAttribute(By elementBy, String attribute){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getAttribute(attribute);
    }
    public WebElement randomElement(By elementBy){
        List<WebElement> list = driver.findElements(elementBy);
        Random random = new Random();
        int randomNumber = random.nextInt(0, list.size());
        return list.get(randomNumber);
    }
    public double getPriceFromElement(By elementBy){
        String priceAsString = readText(elementBy).replace("$", "");
        return Double.parseDouble(priceAsString);
    }
    public WebElement maxElement(By elementBy, By priceBy){
        List<WebElement> list = driver.findElements(elementBy);
        String stringMaxPrice = list.get(0).findElement(priceBy).getText().replace("$", "");
        double maxPrice = Double.parseDouble(stringMaxPrice);
        WebElement maxElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            stringMaxPrice = list.get(i).findElement(priceBy).getText().replace("$", "");
            double newMaxPrice = Double.parseDouble(stringMaxPrice);
            if (maxPrice < newMaxPrice) {
                maxPrice = newMaxPrice;
                maxElement = list.get(i);
            }
        }
        return maxElement;
    }
    public WebElement minElement(By elementBy, By priceBy){
        List<WebElement> list = driver.findElements(elementBy);
        String stringMinPrice = list.get(0).findElement(priceBy).getText().replace("$", "");
        double minPrice = Double.parseDouble(stringMinPrice);
        WebElement minElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            stringMinPrice = list.get(i).findElement(priceBy).getText().replace("$", "");
            double newMinPrice = Double.parseDouble(stringMinPrice);
            if (minPrice > newMinPrice) {
                minPrice = newMinPrice;
                minElement = list.get(i);
            }
        }
        return minElement;
    }
}

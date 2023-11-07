package methods;

import org.openqa.selenium.WebDriver;
import pages.OverviewPage;

public class OverviewMethod extends OverviewPage {
    public OverviewMethod(WebDriver driver) {
        super(driver);
    }
    public void verifyOverview(double expectedPriceFromElement){
        verifyInventoryItemPrice(expectedPriceFromElement);
    }
}

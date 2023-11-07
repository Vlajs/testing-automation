package methods;

import org.openqa.selenium.WebDriver;
import pages.CompletePage;

public class CompleteMethod extends CompletePage {
    public CompleteMethod(WebDriver driver) {
        super(driver);
    }
    public void verifyShopping(String expectedText){
        verifyCompleteShopping(expectedText);
    }
}

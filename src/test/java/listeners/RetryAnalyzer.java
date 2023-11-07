package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private int maxCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count < maxCount) {
                count++;
                return true;
            } else {
                return false;
            }
        } else {
            result.setStatus(1);
        }
        return false;
    }
}

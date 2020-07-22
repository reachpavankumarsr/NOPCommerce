package com.nopecommerce.admin.helper.listener;

import com.nopecommerce.admin.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private Logger log = LoggerHelper.getLogger(Retry.class);

    private int retryCount = 0;
    private int maxTryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxTryCount) {
            log.info("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " times.");
            retryCount++;
            return true;
        }
        return false;

    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1) {
            resultName = "SUCCESS";
        }
        if (status == 2) {
            resultName = "FAILURE";
        }
        if (status == 3) {
            resultName = "SKIPPED";
        }
        return resultName;
    }
}

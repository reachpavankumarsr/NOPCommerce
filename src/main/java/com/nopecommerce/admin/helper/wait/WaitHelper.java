package com.nopecommerce.admin.helper.wait;

import com.nopecommerce.admin.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//PENDING
public class WaitHelper {
    private Logger log = LoggerHelper.getLogger(WaitHelper.class);
    private WebDriver driver;
    private WebDriverWait wait;

    WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method is to set Implicit wait
     *
     * @param timeout
     * @param unit
     */
    public void setImplicitWait(long timeout, TimeUnit unit) {
        log.info(timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
    }

    /**
     * This method is to set Page Load Time Out
     *
     * @param timeout
     * @param unit
     */
    public void setPageLoadTimeout(long timeout, TimeUnit unit) {
        log.info(timeout);
        driver.manage().timeouts().pageLoadTimeout(timeout, unit == null ? TimeUnit.SECONDS : unit);
    }

    /**
     * get wait
     *
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     * @return
     */
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        log.debug("");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    /**
     * This method wait for Element visible
     *
     * @param locator
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     */
    public void waitForElementVisible(WebElement locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
        log.info(locator);
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    /**
     * This method wait for Element visible
     *
     * @param driver
     * @param element
     * @param timeout
     */
    public void waitForElement(WebDriver driver, WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("element found..." + element.getText());
    }

    /**
     * This method wait for element to be clickable
     *
     * @param driver
     * @param time
     * @param element
     * @return
     */
    public WebElement waitForElementToBeClickable(WebDriver driver, long time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method wait for frame to be Available
     *
     * @param element
     * @param timeOutinSeconds
     */
    public void waitForFrameToBeAvailable(WebElement element, long timeOutinSeconds) {
        log.info("waiting for: " + element.toString() + "for: " + timeOutinSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutinSeconds);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("frame is available and switched");

    }

    /**
     * This method wait for Number of Window to be
     *
     * @param noOfWindow
     * @param timeOutinSeconds
     */
    public void waitForNoOfWindowsToBe(int noOfWindow, long timeOutinSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutinSeconds);
        wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindow));
        log.info("frame is available and switched");

    }

    /**
     * This method for get Fluent wait
     *
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     * @return
     */
    private Wait<WebDriver> getFluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
        return fwait;
    }

    /**
     * This method wait for element using fluent wait
     *
     * @param element
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     * @return
     */
    public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
        Wait<WebDriver> fwait = getFluentWait(timeOutInSeconds, pollingEveryInMiliSec);
        fwait.until(ExpectedConditions.visibilityOf(element));
        return element;

    }


}

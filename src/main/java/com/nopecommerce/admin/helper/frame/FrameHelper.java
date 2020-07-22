package com.nopecommerce.admin.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
    private WebDriver driver;
    private Logger log = Logger.getLogger(FrameHelper.class);

    public FrameHelper(WebDriver driver){
        this.driver=driver;
    }

    /**
     * This method is for switch to frame by Index
     * @param frameIndex
     */
    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
        log.info("switched to :" + frameIndex + " frame");
    }

    /**
     * This method is for switch to frame by frame-name
     * @param framename
     */
    public void switchToFrame(String framename) {
        driver.switchTo().frame(framename);
        log.info("switched to :" + framename + " frame");

    }

    /**
     * This method is for switch to frame by WebElement
     * @param element
     */
    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
        log.info("switched to :" + element + " frame");

    }
}

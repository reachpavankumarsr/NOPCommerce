package com.nopecommerce.admin.helper.window;

import com.nopecommerce.admin.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(WindowHelper.class);

    public WindowHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Mehtod for Window switched to parent window
     */
    public void switchToParentWindow() {
        driver.switchTo().defaultContent();
    }

    /**
     * Mehtod for Switch To Window using window Index
     * @param windowIndex
     */
    public void switchToWindow(int windowIndex) {
        Set<String> windows = driver.getWindowHandles();
        int i = 1;
        for (String window : windows) {
            if (i == windowIndex) {
                driver.switchTo().window(window);
                log.info("switched to: "+windowIndex+ " window");
            } else {
                i++;
            }
        }
    }


    /**
     * Mehtod for Close All Tabs And Switched To main window
     */
    public void closeAllTabsAndSwitchToMainWindow(){
        Set<String> windows = driver.getWindowHandles();
        String Parentwindow = driver.getWindowHandle();
        for (String window:windows) {
            if(!window.equalsIgnoreCase(Parentwindow)){
                log.info("Cloes all window or tabs");
                driver.close();
            }

            driver.switchTo().window(Parentwindow);
            log.info("window contol Entered to"+Parentwindow+" window");

        }

    }

    /**
     * Method to navigate back page
     */
    public void navigateBack(){
        driver.navigate().back();
    }

    /**
     * Mehtod to navigate forword
     */
    public void navigateForward(){
        driver.navigate().forward();
    }







}

package com.nopecommerce.admin.helper.javascript;

import com.nopecommerce.admin.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
    private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
    private WebDriver driver;

    JavaScriptHelper(WebDriver driver) {
        this.driver = driver;
        log.info("JavascriptHelper has been initialized");
    }

    public Object executeScript(String script) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script);

    }


    public Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }

    public void scrollToElement(WebElement element) {
        log.info("scroll to WebElement");
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);

    }

    public void scrollToElementAndClick(WebElement element) {
        scrollToElement(element);
        element.click();
        log.info("element is clicked " + element.toString());
    }

    public void scrollIntoView(WebElement element) {
        log.info("scroll till web Element");
        executeScript("arguments[0].scrollIntoView()", element);
    }

    public void scrollIntoViewAndClick(WebElement element){
        scrollIntoView(element);
        element.click();
        log.info("element is clicked: "+element.toString());
    }

    public void scrollDownVertically(){
        executeScript("window.scrollTo(0,document.body.scrollHeight)");
        log.info("scrolling down vertically");
    }

    public void scrollUpVertically(){
        executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        log.info("scrolling up vertically");
    }

    public void scrollDownByPixcel(int pixcel){
        executeScript("window.scrollBY(0,"+pixcel+")");
    }

    public void scrollUpByPixcel(int pixcel){
        executeScript("window.scrollBY(0,-"+pixcel+")");
    }

    public void zoomInBy100Percentage(){
        executeScript("document.body.style.zoom='100%'");
    }

    public void zoomInBy60Percentage(){
        executeScript("document.body.style.zoom='60%'");
    }

    public void clickElement(WebElement element){
        executeScript("arguments[0].click()",element);
    }






}

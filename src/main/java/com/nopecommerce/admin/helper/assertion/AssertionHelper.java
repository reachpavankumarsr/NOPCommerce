package com.nopecommerce.admin.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertionHelper {
    private WebDriver driver;
    private static Logger log = Logger.getLogger(VerificationHelper.class);

    public AssertionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static void verifyText(String s1, String s2){
        log.info("veryfing text: "+s1 +" with "+s2);
        Assert.assertEquals(s1,s2);
    }

    public static void verifyTrue(){
        log.info("making script as PASS");
        Assert.assertTrue(true);
    }

    public static void verifyTrue(String massage){
        log.info("making script as PASS.. "+massage);
        Assert.assertTrue(true,massage);
    }

    public static void verifyFalse(){
        log.info("making script as FAIL.. ");
        Assert.assertFalse(true);
    }

    public static void verifyFalse(String massage){
        log.info("making script as FAIL.. "+massage);
        Assert.assertFalse(true,massage);
    }

    public static void verifyTrue(boolean status){
        Assert.assertTrue(status);
    }

    public static void verifyFalse(boolean status){
        Assert.assertFalse(status);
    }

    public static void verifyNull(WebElement element){
        log.info("veryfing the Object null.. "+element);
        Assert.assertNull(element);
    }
    public static void verifyNotNull(WebElement element){
        log.info("veryfing the Object not null.. "+element);
        Assert.assertNotNull(element);
    }



}

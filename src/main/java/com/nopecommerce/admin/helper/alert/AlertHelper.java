package com.nopecommerce.admin.helper.alert;

import com.nopecommerce.admin.helper.assertion.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
    private WebDriver driver;
    private Logger log = Logger.getLogger(AlertHelper.class);

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
        log.info("AlertHelper Object is created");
    }

    public Alert getAlert(){
        log.info("alert test: "+driver.switchTo().alert().getText());
        return driver.switchTo().alert();
    }

    public void acceptAlert(){
        getAlert().accept();
        log.info("accept alert is done");
    }

    public  void dismissAlert(){
        getAlert().dismiss();
        log.info("dismiss Alert is done");
    }

    public String getAlertText(){
        String text=getAlert().getText();
        log.info("Alert text is: "+getAlert().getText());
        return text;

    }

    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            log.info("alert is present");
            return true;
        }
        catch (Exception ex){
            log.error(ex.getCause());
            return false;
        }
    }

    public void acceptAlertPresent(){
        if (isAlertPresent()){
            acceptAlert();
        }
        else{
            log.info("Alert is not present..");
        }
    }

    public void acceptDismissPresent(){
        if (isAlertPresent()){
            dismissAlert();
        }
        else{
            log.info("Alert is not present..");
        }
    }

    public void acceptPrompt(String text){
        if(isAlertPresent()){
            Alert alert = getAlert();
            alert.sendKeys("text");
            alert.accept();
            log.info("alert text: "+text);
        }
    }

}

package com.nopecommerce.admin.helper.assertion;

import com.nopecommerce.admin.helper.frame.FrameHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationHelper {
    private WebDriver driver;
    private Logger log = Logger.getLogger(VerificationHelper.class);

    public VerificationHelper(WebDriver driver){
        this.driver=driver;
    }

    public boolean isDisplayed(WebElement element){
        try {
            element.isDisplayed();
            log.info("element is present..."+element.getText());
            return true;
        }
        catch (Exception e){
            log.error("element is not present");
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element){
        try {
            element.isDisplayed();
            log.info("element is Displayed..."+element.getText());
            return false;
        }
        catch (Exception e){
            log.error("element is not Displayed");
            return true;
        }
    }

    public String getText(WebElement element){
        if(element==null){
            log.info("element is null");
            return null;
        }
        boolean status=isDisplayed(element);
        if(status){
            log.info("element text is..."+element.getText());
            return element.getText();
        }
        else {
            log.info("element text is not present.."+element.getText());
            return null;

        }
    }


}

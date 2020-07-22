package com.nopecommerce.admin.helper.browserConfiguration;

import com.nopecommerce.admin.helper.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxBrowser {
    public FirefoxOptions getFirefoxOptions(){
        DesiredCapabilities firefox=new DesiredCapabilities();

        FirefoxProfile profile=new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        firefox.setCapability(FirefoxDriver.PROFILE,profile);
        firefox.setCapability("marionette",true);

        FirefoxOptions firefoxOptions=new FirefoxOptions(firefox);
        //Linux
        {
            if(System.getProperty("os.name").contains("Linux")){
                firefoxOptions.addArguments("--headless","window-size=1024,768","--no-sandbox");
            }

        }


        return firefoxOptions;

    }

    public WebDriver getFirefoxDriver(FirefoxOptions cap){
        if(System.getProperty("os.name").contains("window")){
            System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("\\src\\main\\resources\\Drivers\\geckodriver.exe"));
            return new FirefoxDriver(cap);
        }
        return null;
    }
}

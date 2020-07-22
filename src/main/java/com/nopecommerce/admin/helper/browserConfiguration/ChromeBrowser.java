package com.nopecommerce.admin.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser {
    public ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--test-type");
        chromeOptions.addArguments("--disable-popup-blocking");
        DesiredCapabilities chrome=DesiredCapabilities.chrome();
        chrome.setAcceptInsecureCerts(true);
        chrome.setJavascriptEnabled(true);
        chromeOptions.setCapability(chromeOptions.CAPABILITY,chromeOptions);
        //
        if(System.getProperty("os.name").contains("Linux")){
            chromeOptions.addArguments("--headless","window-size=1024,768","--no-sandbox");
        }
        return chromeOptions;
    }

    public WebDriver getChromeDriver(){
        if(System.getProperty("os.name").contains("Mac")){
            //TODO
        }
        else if(System.getProperty("os.name").contains("windows")){
            System.getProperty("driver,chrome.driver","D:\\AutomationTools\\WebDrivers\\chromedriver.exe");
                return new ChromeDriver();
            }
        else if(System.getProperty("os.name").contains("linux")) {
            //TODO

        }
        return null;

    }
}

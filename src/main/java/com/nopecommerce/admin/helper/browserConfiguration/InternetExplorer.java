package com.nopecommerce.admin.helper.browserConfiguration;

import com.nopecommerce.admin.helper.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorer {
    public InternetExplorerOptions getIExplorerCapabilities(){
        DesiredCapabilities cap=DesiredCapabilities.internetExplorer();

        cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
        cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
        cap.setJavascriptEnabled(true);

        InternetExplorerOptions options=new InternetExplorerOptions();
        return options;

    }

    public WebDriver getIExplorerDriver(InternetExplorerOptions cap){
        System.getProperty("webdriver.ie.driver", ResourceHelper.getResourcePath("\\src\\main\\resources\\Drivers\\InternetExplorer"));
        return new InternetExplorerDriver(cap);
    }
}

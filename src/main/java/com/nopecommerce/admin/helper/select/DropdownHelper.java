package com.nopecommerce.admin.helper.select;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class DropdownHelper {
    private WebDriver driver;
    private Logger log = Logger.getLogger(DropdownHelper.class);

    public DropdownHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDropDownByIndex(WebElement element,int index){
        Select select=new Select(element);
        log.info("Select using index: "+index);
        select.selectByIndex(index);

    }

    public void selectDropdownByValue(WebElement element,String value){
        Select select=new Select(element);
        log.info("Select using value: "+value);
        select.selectByValue(value);
    }

    public void selectDropDownByText(WebElement element,String visibletText){
        Select select=new Select(element);
        log.info("Select using visible text: "+visibletText);
        select.selectByVisibleText(visibletText);

    }

    public void deSelectDropDownByIndex(WebElement element,int index){
        Select select=new Select(element);
        log.info("deselect using index: "+index);
        select.selectByIndex(index);

    }

    public void deSelectDropdownByValue(WebElement element,String value){
        Select select=new Select(element);
        log.info("deselect using index: "+value);
        select.selectByValue(value);
    }

    public void deSelectDropDownByText(WebElement element,String visibletText){
        Select select=new Select(element);
        log.info("deselect using index: "+visibletText);
        select.selectByVisibleText(visibletText);

    }

    public void getSelectedOption(WebElement element){
        Select select=new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList=new LinkedList<String>();
        for (WebElement ele:elementList) {
            log.info(ele.getText());
            valueList.add(ele.getText());
        }


    }



}

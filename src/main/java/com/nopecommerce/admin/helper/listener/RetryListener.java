package com.nopecommerce.admin.helper.listener;

import com.nopecommerce.admin.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {
    private Logger log=LoggerHelper.getLogger(RetryListener.class);

    public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3){
        IRetryAnalyzer retry =arg0.getRetryAnalyzer();
        if(retry==null){
            arg0.setRetryAnalyzer(Retry.class);
        }

    }

}

package com.danilovvv.pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    final org.apache.logging.log4j.Logger logger = LogManager.getLogger(BasePage.class);
}

package com.danilovvv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage (WebDriver driver){
        super(driver);
    }

    private final By USERNAME_MENU_PATH =  By.xpath("//p[contains(@class,'username')]");

    private final By ABOUTME_MENU_PATH = By.xpath("//div[@class='header2-menu__dropdown-text']");

    public void aboutMePage(){
        driver.findElement(USERNAME_MENU_PATH).click();
        driver.findElement(ABOUTME_MENU_PATH).click();
    }



    private final By AUTH_PAGE_PATH = By.xpath("//*[contains(text(),'и регистрация')]/parent::button");

    public void authPage(){
        driver.findElement(AUTH_PAGE_PATH).click();
    }

}

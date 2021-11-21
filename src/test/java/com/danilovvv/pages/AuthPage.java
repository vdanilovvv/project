package com.danilovvv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage extends BasePage {

    public AuthPage (WebDriver driver){
        super(driver);
    }



    private final By INPUT_LOGIN_PATH = By.xpath("//form[@action='/login/']/descendant::input[@placeholder='Электронная почта']");
    private final By INPUT_PASSWORD_PATH = By.xpath("//input[@placeholder='Введите пароль']");
    private final By LOGIN_BUTTON_PATH = By.xpath("//form[@action='/login/']//*[contains(text(),'Войти')]");

    public void authorize() {
        driver.findElement(INPUT_LOGIN_PATH).sendKeys(System.getProperty("login"));
        driver.findElement(INPUT_PASSWORD_PATH).sendKeys(System.getProperty("password"));
        driver.findElement(LOGIN_BUTTON_PATH).click();
    }
}
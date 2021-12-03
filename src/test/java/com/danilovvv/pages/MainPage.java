package com.danilovvv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
    public MainPage (WebDriver driver){
        super(driver);
    }

    private final By LESSONS_MENU_PATH = By.xpath("//div[@class='header2-menu header2-menu_main']/.//p[text()='Курсы']");
    private final By TESTING_LESSONS_MENU_PATH = By.xpath("//div[@class='header2-menu header2-menu_main']/.//a[@title='Тестирование']");

    private final By EVENTS_MENU_PATH = By.xpath("//div[@class='header2-menu header2-menu_main']/.//p[text()='События']");
    private final By EVENTS_CALENDAR_MENU_PATH = By.xpath("//div[@class='header2-menu header2-menu_main']/.//a[@title='Календарь мероприятий']");

    private final By AUTH_PAGE_PATH = By.xpath("//*[contains(text(),'и регистрация')]/parent::button");

    public void openTestingLessonsPage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(LESSONS_MENU_PATH)));
        driver.findElement(LESSONS_MENU_PATH).click();
        driver.findElement(TESTING_LESSONS_MENU_PATH).click();
    }

    public void openEventsCalendarPage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(EVENTS_MENU_PATH)));
        driver.findElement(EVENTS_MENU_PATH).click();
        driver.findElement(EVENTS_CALENDAR_MENU_PATH).click();
    }

    public void openAuthPage(){
        driver.findElement(AUTH_PAGE_PATH).click();
    }

}

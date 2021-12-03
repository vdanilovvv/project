package com.danilovvv.pages;

import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class EventsCalendarPage extends BasePage {

    public EventsCalendarPage(WebDriver driver) {
        super(driver);
    }

    private final By EVENT_CALENDAR_DATE_PATH = By.xpath("//span[@class='dod_new-event__icon dod_new-event__calendar-icon']/following-sibling::span");
    private final By EVENT_CALENDAR_BUTTON_PATH = By.xpath("//*[contains(text(),'Посетить')]");
    private final By LOADING_EVENT_PATH = By.xpath("//div[contains(@class,'dod_new-loader-wrapper-visible')]");

    private final By OPEN_EVENTS_MENU_PATH = By.xpath("//div[@class='dod_new-events-dropdown js-dod_new_events-dropdown']");
    private final By SELECT_DOD_SORT_PATH = By.xpath("//div[@class='dod_new-events-dropdown js-dod_new_events-dropdown dod_new-events-dropdown_opened']/following::a[@title='ДОД']");
    private final By DOD_EVENTS_PATH = By.xpath("//div[@class='dod_new-type__text' and text()='День открытых дверей']");

    public void loadAllEvents() {
        boolean anotherOne = false;
        while (!anotherOne) {
            int firstCheck = driver.findElements(EVENT_CALENDAR_BUTTON_PATH).size();
            driver.findElement(EVENT_CALENDAR_BUTTON_PATH).sendKeys(Keys.END);
            driver.findElements(LOADING_EVENT_PATH).size();
            int secondCheck = driver.findElements(EVENT_CALENDAR_BUTTON_PATH).size();
            anotherOne = (firstCheck == secondCheck);
        }
        driver.findElement(EVENT_CALENDAR_BUTTON_PATH).sendKeys(Keys.HOME);
    }

    public List<WebElement> getListEvents() {
        return driver.findElements(EVENT_CALENDAR_DATE_PATH);
    }

    public List<WebElement> getDodEvents() {
        return driver.findElements(DOD_EVENTS_PATH);
    }

    public Date getMonth (Date date, int month){
        date.setMonth(month);
        Date dateCurrent = new Date();
        if (date.getMonth() < dateCurrent.getMonth()) {
            date = DateUtils.addYears(date, 1);
        }
        return date;
    }


    public Date getDate(String date){
        String day = date.replaceAll("\\D+", "");
        String month = date.replaceAll("[^а-я]", "");
        Date datePage = new Date();
        int dayInt = Integer.parseInt(day);
        datePage.setDate(dayInt);
        Date datePageMonth = new Date();
        switch (month) {
            case "января":
                datePageMonth = getMonth(datePage,Calendar.JANUARY);
                break;
            case "февраля":
                datePageMonth = getMonth(datePage,Calendar.FEBRUARY);
                break;
            case "марта":
                datePageMonth = getMonth(datePage,Calendar.MARCH);
                break;
            case "апреля":
                datePageMonth = getMonth(datePage,Calendar.APRIL);
                break;
            case "мая":
                datePageMonth = getMonth(datePage,Calendar.MAY);
                break;
            case "июня":
                datePageMonth = getMonth(datePage,Calendar.JUNE);
                break;
            case "июля":
                datePageMonth = getMonth(datePage,Calendar.JULY);
                break;
            case "августа":
                datePageMonth = getMonth(datePage,Calendar.AUGUST);
                break;
            case "сентября":
                datePageMonth = getMonth(datePage,Calendar.SEPTEMBER);
                break;
            case "октября":
                datePageMonth = getMonth(datePage,Calendar.OCTOBER);
                break;
            case "ноября":
                datePageMonth = getMonth(datePage,Calendar.NOVEMBER);
                break;
            case "декабря":
                datePageMonth = getMonth(datePage,Calendar.DECEMBER);
                break;
        }
        return datePageMonth;
    }

    public void goToDodEvents() {
        driver.findElement(OPEN_EVENTS_MENU_PATH).click();
        String path = driver.findElement(SELECT_DOD_SORT_PATH).getAttribute("href");
        driver.get(path);
    }

}

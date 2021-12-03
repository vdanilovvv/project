package com.danilovvv;

import com.danilovvv.pages.AuthPage;
import com.danilovvv.pages.EventsCalendarPage;
import com.danilovvv.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;


public class EventsCalendarPageTest extends BaseTest {


    @Test
    public void test3CheckEventsCalendarDates() {
        MainPage mainpage = new MainPage(driver);
        mainpage.openAuthPage();
        AuthPage authPage = new AuthPage(driver);
        authPage.authorize();
        mainpage.openEventsCalendarPage();

        EventsCalendarPage events = new EventsCalendarPage(driver);
        events.loadAllEvents();
        List<WebElement> list = events.getListEvents();
        for (int i = 0; i < list.size(); i++){
            String date = list.get(i).getText();
            Date datePage = events.getDate(date);
            Date dateCurrent = new Date();
            Assert.assertTrue(datePage.equals(dateCurrent) | datePage.after(dateCurrent));
        }
        logger.info("Все даты проведения мероприятий больше или равны текущей даты");
    }



    @Test
    public void test4CheckDodEvents() {
        MainPage mainpage = new MainPage(driver);
        mainpage.openAuthPage();
        AuthPage authPage = new AuthPage(driver);
        authPage.authorize();
        mainpage.openEventsCalendarPage();

        EventsCalendarPage events = new EventsCalendarPage(driver);
        events.goToDodEvents();
        events.loadAllEvents();
        int allEventsSize = events.getListEvents().size();
        int dodEventsSize = events.getDodEvents().size();
        Assert.assertEquals(allEventsSize, dodEventsSize);
        logger.info("Все мероприятия на данной странице имеют тип 'ДОД'");

    }
}

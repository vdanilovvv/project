package com.danilovvv;

import com.danilovvv.pages.AuthPage;
import com.danilovvv.pages.MainPage;
import com.danilovvv.pages.TestingLessonsPage;
import org.junit.*;

public class TestingLessonsPageTest extends BaseTest {

    @Test
    public void test1CheckCountLessons() {
        MainPage mainpage = new MainPage(driver);
        mainpage.openAuthPage();

        AuthPage authPage = new AuthPage(driver);
        authPage.authorize();

        mainpage.openTestingLessonsPage();

        TestingLessonsPage testing = new TestingLessonsPage(driver);
        int lessonsTextCount = testing.checkLessonsTextCount();
        int lessonsButtonCount = testing.checkLessonsButtonCount();
        Assert.assertEquals(lessonsTextCount,lessonsButtonCount);
        logger.info("Количество курсов в разделе 'Тестирование' = "+ lessonsTextCount);
    }

    @Test
    public void test2CheckTestingLessons() {
        MainPage mainpage = new MainPage(driver);
        mainpage.openAuthPage();

        AuthPage authPage = new AuthPage(driver);
        authPage.authorize();

        mainpage.openTestingLessonsPage();

        TestingLessonsPage testing = new TestingLessonsPage(driver);
        testing.getLessonsInfo();
    }
}

package com.danilovvv;

import com.danilovvv.pages.AboutMePage;
import com.danilovvv.pages.AuthPage;
import com.danilovvv.pages.MainPage;
import org.junit.*;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AboutMePageTest extends BaseTest {
    final String RUS_FIRST_NAME = "Всеволод";
    final String ENG_FIRST_NAME = "Vsevolod";
    final String RUS_SECOND_NAME = "Данилов";
    final String ENG_SECOND_NAME = "Danilov";
    final String BLOG_NAME = "DanilovOTUS";
    final String BIRTHDAY = "29.09.1994";
    final String COUNTRY = "Россия";
    final String CITY = "Москва";
    final String ENG_LEVEL = "Начальный уровень (Beginner)";
    final String CONTACT1 = "TG_CONTACT";
    final String CONTACT1_VIEW = "Тelegram";
    final String TG_CONTACT = "@danilovTest";
    final String CONTACT2 = "VK_CONTACT";
    final String CONTACT2_VIEW = "VK";
    final String VK_CONTACT = "vk.com/danilov_test";
    final String COMPANY = "Тестовая компания";
    final String POSITION = "Тестировщик";
    final String GENDER = "Мужской";
    final String COMPUTER_LANGUAGE = "Java";
    final String COMPUTER_LANG_EXP = "Только начал";



    @Test
    public void test1InputData() {
        AuthPage authPage = new AuthPage(driver);
        AboutMePage aboutMePage = new AboutMePage(driver);
        MainPage mainpage = new MainPage(driver);

        mainpage.authPage();
        authPage.authorize();
        mainpage.aboutMePage();

        aboutMePage.inputRuFirstName(RUS_FIRST_NAME);
        aboutMePage.inputEngFirstName(ENG_FIRST_NAME);
        aboutMePage.inputRuSecondName(RUS_SECOND_NAME);
        aboutMePage.inputEngSecondName(ENG_SECOND_NAME);
        aboutMePage.inputBlogName(BLOG_NAME);
        aboutMePage.inputBirthday(BIRTHDAY);
        aboutMePage.inputCountry(COUNTRY);

        aboutMePage.inputEngLevel(ENG_LEVEL);

        aboutMePage.inputRelocateReady();
        aboutMePage.inputFullDay();

        aboutMePage.inputCityName(CITY);

        aboutMePage.addContact(CONTACT1,TG_CONTACT);
        aboutMePage.addContact(CONTACT2,VK_CONTACT);

        aboutMePage.inputEmailPrefer();

        aboutMePage.inputMaleGender();
        aboutMePage.inputCompany(COMPANY);
        aboutMePage.inputWork(POSITION);

        aboutMePage.inputJavaExp();

        aboutMePage.saveAndContinue();
    }


    @Test
    public void test2CheckData(){
        AuthPage authPage = new AuthPage(driver);
        AboutMePage aboutMePage = new AboutMePage(driver);
        MainPage mainpage = new MainPage(driver);

        mainpage.authPage();
        authPage.authorize();
        mainpage.aboutMePage();

        aboutMePage.assertRuFirstName(RUS_FIRST_NAME);
        aboutMePage.assertEngFirstName(ENG_FIRST_NAME);
        aboutMePage.assertRuSecondName(RUS_SECOND_NAME);
        aboutMePage.assertEngSecondName(ENG_SECOND_NAME);
        aboutMePage.assertBlogName(BLOG_NAME);
        aboutMePage.assertBirthday(BIRTHDAY);
        aboutMePage.assertCountry(COUNTRY);
        aboutMePage.assertCity(CITY);
        aboutMePage.assertEngLvl(ENG_LEVEL);
        aboutMePage.assertRelocate();
        aboutMePage.assertContactView(CONTACT1_VIEW);
        aboutMePage.assertFirstContactValue(TG_CONTACT);
        aboutMePage.assertContactView(CONTACT2_VIEW);
        aboutMePage.assertSecondContactValue(VK_CONTACT);
        aboutMePage.assertEmailSelected();
        aboutMePage.assertGender(GENDER);
        aboutMePage.assertCompany(COMPANY);
        aboutMePage.assertWork(POSITION);
        aboutMePage.assertCompLanguage(COMPUTER_LANGUAGE);
        aboutMePage.assertCompLangExp(COMPUTER_LANG_EXP);
    }


}

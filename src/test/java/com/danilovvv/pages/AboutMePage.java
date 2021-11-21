package com.danilovvv.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutMePage extends BasePage {

    public AboutMePage (WebDriver driver){
        super(driver);
    }


    private final By RUS_FIRST_NAME_PATH = By.xpath("//*[@id=\"id_fname\"]");

    public void inputRuFirstName (String name){
        driver.findElement(RUS_FIRST_NAME_PATH).clear();
        driver.findElement(RUS_FIRST_NAME_PATH).sendKeys(name);
    }

    public void assertRuFirstName (String name){
        Assert.assertEquals(name, driver.findElement(RUS_FIRST_NAME_PATH).getAttribute("value"));
    }





    private final By ENG_FIRST_NAME_PATH = By.xpath("//*[@id=\"id_fname_latin\"]");

    public void inputEngFirstName (String name){
        driver.findElement(ENG_FIRST_NAME_PATH).clear();
        driver.findElement(ENG_FIRST_NAME_PATH).sendKeys(name);
    }

    public void assertEngFirstName (String name){
        Assert.assertEquals(name, driver.findElement(ENG_FIRST_NAME_PATH).getAttribute("value"));
    }





    private final By RUS_SECOND_NAME_PATH = By.xpath("//*[@id=\"id_lname\"]");

    public void inputRuSecondName (String name){
        driver.findElement(RUS_SECOND_NAME_PATH).clear();
        driver.findElement(RUS_SECOND_NAME_PATH).sendKeys(name);
    }

    public void assertRuSecondName (String name){
        Assert.assertEquals(name, driver.findElement(RUS_SECOND_NAME_PATH).getAttribute("value"));
    }





    private final By ENG_SECOND_NAME_PATH = By.xpath("//*[@id=\"id_lname_latin\"]");

    public void inputEngSecondName (String name){
        driver.findElement(ENG_SECOND_NAME_PATH).clear();
        driver.findElement(ENG_SECOND_NAME_PATH).sendKeys(name);
    }

    public void assertEngSecondName (String name){
        Assert.assertEquals(name, driver.findElement(ENG_SECOND_NAME_PATH).getAttribute("value"));
    }





    private final By BLOG_NAME_PATH = By.xpath("//*[@id=\"id_blog_name\"]");

    public void inputBlogName (String name){
        driver.findElement(BLOG_NAME_PATH).clear();
        driver.findElement(BLOG_NAME_PATH).sendKeys(name);
    }

    public void assertBlogName (String name){
        Assert.assertEquals(name, driver.findElement(BLOG_NAME_PATH).getAttribute("value"));
    }





    private final By BIRTHDAY_PATH = By.xpath("//*[@title='День рождения']");

    public void inputBirthday (String name){
        driver.findElement(BIRTHDAY_PATH).clear();
        driver.findElement(BIRTHDAY_PATH).sendKeys(name);
    }

    public void assertBirthday (String name){
        Assert.assertEquals(name, driver.findElement(BIRTHDAY_PATH).getAttribute("value"));
    }





    private final By COUNTRY_OPEN_MENU_PATH = By.xpath("//*[@name='country']/following-sibling::div");

    public By countryNameXpath(String name){
        return By.xpath("//*[@title='"+ name + "']");
    }

    public void inputCountry (String name){
        driver.findElement(COUNTRY_OPEN_MENU_PATH).click();
        driver.findElement(countryNameXpath(name)).click();
    }

    public void assertCountry (String name){
        Assert.assertEquals(name, driver.findElement(COUNTRY_OPEN_MENU_PATH).getText());
    }





    private final By ENG_LEVEL_OPEN_MENU_PATH = By.xpath("//*[@name='english_level']/following-sibling::div");
    private final By ENG_LEVEL_TEXT = By.xpath("//*[@data-title='Уровень знания английского языка']/following-sibling::div");

    public By engLvlNameXpath(String name){
        return By.xpath("//*[@title='"+ name + "']");
    }

    public void inputEngLevel (String name){
        driver.findElement(ENG_LEVEL_OPEN_MENU_PATH).click();
        driver.findElement(engLvlNameXpath(name)).click();
    }

    public void assertEngLvl (String name){
        Assert.assertEquals(name, driver.findElement(ENG_LEVEL_TEXT).getText());
    }




    private final By CHECK_READY_RELOCATE_PATH = By.xpath("//*[@id='id_ready_to_relocate_1']");

    private final By SELECT_READY_RELOCATE_PATH = By.xpath("//*[@id='id_ready_to_relocate_1']/..");

    public void inputRelocateReady(){
        if ((!driver.findElement(CHECK_READY_RELOCATE_PATH).isSelected())) {
            driver.findElement(SELECT_READY_RELOCATE_PATH).click();
        }
    }

    public void assertRelocate (){
        Assert.assertTrue(driver.findElement(CHECK_READY_RELOCATE_PATH).isSelected());
    }





    private final By FULL_DAY_PATH = By.xpath("//*[@title='Полный день']");

    public void inputFullDay(){
        if ((!driver.findElement(FULL_DAY_PATH).isSelected())) {
            driver.findElement(FULL_DAY_PATH).click();
        }
    }




    private final By CITY_OPEN_MENU_PATH = By.xpath("//*[@name='city']/following-sibling::div");

    public By cityNameXpath(String name){
        return By.xpath("//*[@title='" + name + "']");
    }

    public void inputCityName (String name){
        driver.findElement(CITY_OPEN_MENU_PATH).click();
        driver.findElement(cityNameXpath(name)).click();
    }

    public void assertCity (String name){
        Assert.assertEquals(name, driver.findElement(CITY_OPEN_MENU_PATH).getText());
    }




    public void addContact(String contactView, String contactParam){
        By checkXpath = By.xpath("//input[@value='" + contactParam + "']");
        By selectView = By.xpath("//span[text()='Способ связи']/../../following-sibling::div/descendant::button[@title='" + contactView + "']");
        By inputParam = By.xpath("//div[text()='" + contactView + "']/../../following-sibling::input");

        if (driver.findElements(checkXpath).isEmpty()){
            driver.findElement(By.xpath("//button[text()='Добавить']")).click();
            driver.findElement(By.xpath("//span[text()='Способ связи']/..")).click();
            driver.findElement(selectView).click();
            driver.findElement(inputParam).clear();
            driver.findElement(inputParam).sendKeys(contactParam);
        }
    }

    public void assertContactView (String name){
        By path = By.xpath("//div[contains(text(),'" + name + "')]");
        Assert.assertEquals(name, driver.findElement(path).getText());

    }

    private final By firstContactValue = By.cssSelector("#id_contact-0-value");



    public void assertFirstContactValue (String name){
        Assert.assertEquals(name, driver.findElement(firstContactValue).getAttribute("value"));
    }

    private final By secondContactValue = By.cssSelector("#id_contact-1-value");

    public void assertSecondContactValue (String name){
        Assert.assertEquals(name, driver.findElement(secondContactValue).getAttribute("value"));
    }




    private final By CHECK_EMAIL_SELECTED_PATH = By.xpath("//*[@id='id_is_email_preferable']");

    private final By CLICK_EMAIL_SELECTED_PATH = By.xpath("//*[@id='id_is_email_preferable']/parent::*");

    public void inputEmailPrefer() {
        if ((!driver.findElement(CHECK_EMAIL_SELECTED_PATH).isSelected())) {
            driver.findElement(CLICK_EMAIL_SELECTED_PATH).click();
        }
    }

    public void assertEmailSelected (){
        Assert.assertTrue(driver.findElement(CHECK_EMAIL_SELECTED_PATH).isSelected());
    }





    private final By GENDER_MENU_PATH = By.xpath("//*[@id=\"id_gender\"]");

    private final By SELECT_MALE_GENDER_PATH = By.xpath("//*[@id=\"id_gender\"]/option[2]");

    public void inputMaleGender (){
        driver.findElement(GENDER_MENU_PATH).click();
        driver.findElement(SELECT_MALE_GENDER_PATH).click();
    }

    private final By CHECK_GENDER = By.xpath("//*[@id='id_gender']/descendant::option[@selected='']");

    public void assertGender (String name){
        Assert.assertEquals(name, driver.findElement(CHECK_GENDER).getText());
    }


    private final By COMPANY_NAME_PATH = By.xpath("//*[@id=\"id_company\"]");

    public void inputCompany (String name){
        driver.findElement(COMPANY_NAME_PATH).clear();
        driver.findElement(COMPANY_NAME_PATH).sendKeys(name);
    }

    public void assertCompany (String name){
        Assert.assertEquals(name, driver.findElement(COMPANY_NAME_PATH).getAttribute("value"));
    }





    private final By WORK_NAME_PATH = By.xpath("//*[@id=\"id_work\"]");

    public void inputWork (String name){
        driver.findElement(WORK_NAME_PATH).clear();
        driver.findElement(WORK_NAME_PATH).sendKeys(name);
    }

    public void assertWork (String name){
        Assert.assertEquals(name, driver.findElement(WORK_NAME_PATH).getAttribute("value"));
    }





    private final By DELETE_EXP_BUTTON = By.xpath("//*[@class='experience-row__remove ic-close js-formset-delete']");
    private final By ADD_EXP_BUTTON = By.xpath("//a[@class='experience-add js-formset-add']");
    private final By OPEN_EXP_MENU_PATH = By.xpath("//*[@id=\"id_experience-0-experience\"]");
    private final By SELECT_JAVA_EXP_PATH = By.xpath("//*[@title='Сохранить и продолжить']");

    public void inputJavaExp(){
        if ((driver.findElements(DELETE_EXP_BUTTON).isEmpty())) {
            driver.findElement(ADD_EXP_BUTTON).click();
            driver.findElement(OPEN_EXP_MENU_PATH).click();
            driver.findElement(SELECT_JAVA_EXP_PATH).click();
        }
    }

    private final By CHECK_COMP_LANG_PATH = By.xpath("//*[@id='id_experience-0-experience']/descendant::option[@selected='']");

    public void assertCompLanguage (String name){
        Assert.assertEquals(name, driver.findElement(CHECK_COMP_LANG_PATH).getText());
    }

    private final By CHECK_COMP_LANG_EXP_PATH = By.xpath("//*[@id='id_experience-0-level']/descendant::option[@selected='']");

    public void assertCompLangExp (String name){
        Assert.assertEquals(name, driver.findElement(CHECK_COMP_LANG_EXP_PATH).getText());
    }




    private final By SAVE_AND_CONTINUE_BUTTON = By.xpath("//*[@title='Сохранить и продолжить']");

    public void saveAndContinue(){
        driver.findElement(SAVE_AND_CONTINUE_BUTTON).click();
    }

















}

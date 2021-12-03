package com.danilovvv.pages;

import org.openqa.selenium.*;
import java.util.List;

public class TestingLessonsPage extends BasePage {

    public TestingLessonsPage(WebDriver driver) {
        super(driver);
    }

    private final By COUNT_LESSONS_PATH = By.xpath("//div[contains(text(),'Курсов:')]");
    private final By BUTTON_LESSON_PATH = By.xpath("//a[@class='js-stats lessons__new-item lessons__new-item_hovered']");

    private final By LESSON_TITLE_PATH = By.xpath("//*[@class='course-header2__title']");
    private final By LESSON_DESCRIPTION_PATH = By.xpath("//div[@class='course-header2__admin-text']");
    private final By LESSON_DURATION_PATH = By.xpath("//p[contains(text(),'Длительность обучения')]/../../following-sibling::div/descendant::p[@class]");

    public int checkLessonsTextCount() {
        String textCount = driver.findElement(COUNT_LESSONS_PATH).getText();
        String textNumberCount = textCount.replaceAll("\\D+", "");
        return Integer.parseInt(textNumberCount);
    }

    public int checkLessonsButtonCount() {
        return driver.findElements(BUTTON_LESSON_PATH).size();
    }

     public void getLessonsInfo() {
        List<WebElement> elements = driver.findElements(BUTTON_LESSON_PATH);
//        for (int i=0; i<elements.size(); i++) {
        for (int i = 0; i < 3; i++) {
            List<WebElement> elements2 = driver.findElements(BUTTON_LESSON_PATH);
            try {
                elements2.get(i).click();
            } catch (ElementClickInterceptedException exp) {
                elements2.get(i).sendKeys(Keys.SPACE);
                elements2.get(i).click();
            }
            String title = driver.findElement(LESSON_TITLE_PATH).getText();
            String desc = driver.findElement(LESSON_DESCRIPTION_PATH).getText();
            String duration = driver.findElement(LESSON_DURATION_PATH).getText();
            logger.info("Название курса №" + (i+1) + ": " + title);
            logger.info("Описание курса №" + (i+1) + ": " + desc);
            logger.info("Длительность курса №" + (i+1) + ": " + duration);
            driver.get("https://otus.ru/categories/testing/");
        }
    }
}

package com.danilovvv;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestingLessonsPageTest.class);
    protected WebDriver driver;

    final String URL = "https://otus.ru";

    @Before
    public void startUp() {
        String browser = System.getProperty("browser").toUpperCase(Locale.ROOT).trim();
        Browsers enumBrowser = Browsers.valueOf(browser);
        switch (enumBrowser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Драйвер поднят");
        driver.get(URL);
    }

    @After
    public void end() {
        if (driver != null)
            driver.quit();
    }

}

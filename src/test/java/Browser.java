import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Browser {

    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Browser.class);
    protected WebDriver driver;

    @Before
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Драйвер поднят");
    }

    @After
    public void End() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void task1() {
        driver.quit();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.xpath("//*[@id=\"search_form_input_homepage\"]")).sendKeys("ОТУС");
        driver.findElement(By.xpath("//*[@id=\"search_button_homepage\"]")).click();
        Assert.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение", driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div/h2/a[1]")).getText());
    }

    @Test
    public void task2() {
        driver.quit();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--kiosk");
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        driver.findElement(By.xpath("/html/body/section[2]/div/ul[2]/li[1]/span/a/div[1]")).click();
        Assert.assertEquals("pp_hoverContainer", driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/div/div/div[2]/div[1]")).getAttribute("class"));
    }

    @Test
    public void task3() {
        driver.get("https://otus.ru");
        driver.findElement(By.cssSelector("button.header2__auth")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("gacojib958@otozuz.com");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[3]/input")).sendKeys("qwer1234");
        driver.findElement(By.cssSelector("button.new-button")).click();
        logger.info(driver.manage().getCookies());
    }
}

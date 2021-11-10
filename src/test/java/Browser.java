import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.apache.logging.log4j.LogManager;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Browser {


    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Browser.class);
    protected WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Драйвер поднят");
    }

    @After
    public void end() {
        if (driver != null)
            driver.quit();
    }


    final String RUS_FIRST_NAME = "Всеволод";
    final String ENG_FIRST_NAME = "Vsevolod";
    final String RUS_SECOND_NAME = "Данилов";
    final String ENG_SECOND_NAME = "Danilov";
    final String BLOG_NAME = "DanilovOTUS";
    final String BIRTHDAY = "29.09.1994";
    final String VK_CONTACT = "vk.com/danilov_test";
    final String TG_CONTACT = "@danilovTest";
    final String COMPANY = "Тестовая компания";
    final String POSITION = "Тестировщик";


    public void aboutMe() {
        driver.get("https://otus.ru");
        driver.findElement(By.xpath("//*[contains(text(),'и регистрация')]/parent::button")).click();
        driver.findElement(By.xpath("//form[@action='/login/']/descendant::input[@placeholder='Электронная почта']")).sendKeys(System.getProperty("login"));
        driver.findElement(By.xpath("//input[@placeholder='Введите пароль']")).sendKeys(System.getProperty("password"));
        driver.findElement(By.xpath("//form[@action='/login/']//*[contains(text(),'Войти')]")).click();
        driver.findElement(By.xpath("//p[contains(@class,'username')]")).click();
        driver.findElement(By.xpath("//div[@class='header2-menu__dropdown-text']")).click();
    }


    @Test
    public void test1InputData() {
        aboutMe();
        driver.findElement(By.xpath("//*[@id=\"id_fname\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"id_fname\"]")).sendKeys(RUS_FIRST_NAME);
        driver.findElement(By.xpath("//*[@id=\"id_fname_latin\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"id_fname_latin\"]")).sendKeys(ENG_FIRST_NAME);
        driver.findElement(By.xpath("//*[@id=\"id_lname\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"id_lname\"]")).sendKeys(RUS_SECOND_NAME);
        driver.findElement(By.xpath("//*[@id=\"id_lname_latin\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"id_lname_latin\"]")).sendKeys(ENG_SECOND_NAME);
        driver.findElement(By.xpath("//*[@id=\"id_blog_name\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"id_blog_name\"]")).sendKeys(BLOG_NAME);
        driver.findElement(By.xpath("//*[@title='День рождения']")).clear();
        driver.findElement(By.xpath("//*[@title='День рождения']")).sendKeys(BIRTHDAY);
        driver.findElement(By.xpath("//*[@name='country']/following-sibling::div")).click();
        driver.findElement(By.xpath("//*[@title='Россия']")).click();


        driver.findElement(By.xpath("//*[@name='english_level']/following-sibling::div")).click();
        driver.findElement(By.xpath("//*[@title='Начальный уровень (Beginner)']")).click();

        if ((!driver.findElement(By.xpath("//*[@id='id_ready_to_relocate_1']")).isSelected())) {
            driver.findElement(By.xpath("//*[@id='id_ready_to_relocate_1']/..")).click();
        }
        if ((!driver.findElement(By.xpath("//*[@title='Полный день']")).isSelected())) {
            driver.findElement(By.xpath("//*[@title='Полный день']/..")).click();
        }

        driver.findElement(By.xpath("//*[@name='city']/following-sibling::div")).click();
        driver.findElement(By.xpath("//*[@title='Москва']")).click();

        if (driver.findElements(By.xpath("//input[@value='" + VK_CONTACT + "']")).isEmpty()) {
            driver.findElement(By.xpath("//button[text()='Добавить']")).click();
            driver.findElement(By.xpath("//span[text()='Способ связи']/..")).click();
            driver.findElement(By.xpath("//span[text()='Способ связи']/../../following-sibling::div/descendant::button[@title='VK']")).click();
            driver.findElement(By.xpath("//div[text()='VK']/../../following-sibling::input")).clear();
            driver.findElement(By.xpath("//div[text()='VK']/../../following-sibling::input")).sendKeys(VK_CONTACT);
        }


        if (driver.findElements(By.xpath("//input[@value='" + TG_CONTACT + "']")).isEmpty()) {
            driver.findElement(By.xpath("//button[text()='Добавить']")).click();
            driver.findElement(By.xpath("//span[text()='Способ связи']/..")).click();
            driver.findElement(By.xpath("//span[text()='Способ связи']/../../following-sibling::div/descendant::button[@title='Тelegram']")).click();
            driver.findElement(By.xpath("//div[text()='Тelegram']/../../following-sibling::input")).clear();
            driver.findElement(By.xpath("//div[text()='Тelegram']/../../following-sibling::input")).sendKeys(TG_CONTACT);
        }
        if ((!driver.findElement(By.xpath("//*[@id='id_is_email_preferable']")).isSelected())) {
            driver.findElement(By.xpath("//*[@id='id_is_email_preferable']/parent::*")).click();
        }

        driver.findElement(By.xpath("//*[@id=\"id_gender\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"id_gender\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"id_company\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"id_company\"]")).sendKeys(COMPANY);
        driver.findElement(By.xpath("//*[@id=\"id_work\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"id_work\"]")).sendKeys(POSITION);


        if ((driver.findElements(By.xpath("//*[@class='experience-row__remove ic-close js-formset-delete']")).isEmpty())) {
            driver.findElement(By.xpath("//a[@class='experience-add js-formset-add']")).click();
            driver.findElement(By.xpath("//*[@id=\"id_experience-0-experience\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"id_experience-0-experience\"]/option[3]")).click();
        }

        driver.findElement(By.xpath("//*[@title='Сохранить и продолжить']")).click();

    }


    @Test
    public void test2CheckData(){
        aboutMe();
        Assert.assertEquals(RUS_FIRST_NAME, driver.findElement(By.xpath("//*[@id=\"id_fname\"]")).getAttribute("value"));
        Assert.assertEquals(ENG_FIRST_NAME, driver.findElement(By.xpath("//*[@id=\"id_fname_latin\"]")).getAttribute("value"));
        Assert.assertEquals(RUS_SECOND_NAME, driver.findElement(By.xpath("//*[@id=\"id_lname\"]")).getAttribute("value"));
        Assert.assertEquals(ENG_SECOND_NAME, driver.findElement(By.xpath("//*[@id=\"id_lname_latin\"]")).getAttribute("value"));
        Assert.assertEquals(BLOG_NAME, driver.findElement(By.xpath("//*[@id=\"id_blog_name\"]")).getAttribute("value"));
        Assert.assertEquals(BIRTHDAY, driver.findElement(By.xpath("//*[@title='День рождения']")).getAttribute("value"));
        Assert.assertEquals("Россия", driver.findElement(By.xpath("//*[@name='country']/following-sibling::div")).getText());
        Assert.assertEquals("Москва", driver.findElement(By.xpath("//*[@data-title='Город']/following-sibling::div")).getText());
        Assert.assertEquals("Начальный уровень (Beginner)", driver.findElement(By.xpath("//*[@data-title='Уровень знания английского языка']/following-sibling::div")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector("#id_ready_to_relocate_1")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='id_ready_to_relocate_1']")).isSelected());
        Assert.assertEquals("Тelegram", driver.findElement(By.xpath("//*[@value='telegram']/following-sibling::div")).getText());
        Assert.assertEquals(TG_CONTACT, driver.findElement(By.cssSelector("#id_contact-0-value")).getAttribute("value"));
        Assert.assertEquals("VK", driver.findElement(By.xpath("//*[@value='vk']/following-sibling::div")).getText());
        Assert.assertEquals(VK_CONTACT, driver.findElement(By.cssSelector("#id_contact-1-value")).getAttribute("value"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#id_is_email_preferable")).isSelected());
        Assert.assertEquals("Мужской", driver.findElement(By.xpath("//*[@id='id_gender']/descendant::option[@selected='']")).getText());
        Assert.assertEquals("Тестовая компания", driver.findElement(By.xpath("//*[@id=\"id_company\"]")).getAttribute("value"));
        Assert.assertEquals("Тестировщик", driver.findElement(By.xpath("//*[@id=\"id_work\"]")).getAttribute("value"));
        Assert.assertEquals("Java", driver.findElement(By.xpath("//*[@id='id_experience-0-experience']/descendant::option[@selected='']")).getText());
        Assert.assertEquals("Только начал", driver.findElement(By.xpath("//*[@id='id_experience-0-level']/descendant::option[@selected='']")).getText());
    }


}

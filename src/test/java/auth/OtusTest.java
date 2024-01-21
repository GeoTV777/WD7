package auth;

import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.WaitTools;

import java.time.Duration;

public class OtusTest {
    private Logger logger = (Logger) LogManager.getLogger("WD7");
    private String login= System.getProperty("login");
    private String password= System.getProperty("password");
    private WebDriver driver;
    private WaitTools waitTools;
//    private WebDriverWait webDriverWait;
    private String baseUrl = System.getProperty("base.url");

    @BeforeEach
    public void init() {
        driver = new DriverFactory().create();
        waitTools = new WaitTools(driver);
        driver.get(baseUrl);
    }

        @AfterEach
    public void driverStop() {
            if (driver != null) {
                logger.info("Close browser");
                driver.close();
                driver.quit();
            }
    }

            @Test
            public void autorization() {
                String signInButtonLocator = "//button[text()='Войти']";
                WebElement signInButton = driver.findElement(By.xpath(signInButtonLocator));

                String signInPopapSelector = "#__PORTAL__ > div";
                Assertions.assertTrue(waitTools.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector(signInPopapSelector))),"Error");

                signInButton.click();

                WebElement authPopapElement = driver.findElement(By.cssSelector(signInPopapSelector));

                Assertions.assertTrue(waitTools.waitForCondition(ExpectedConditions.visibilityOf(authPopapElement)), "Error?");

                driver.findElement(By.xpath("//input[@name]/..")).click();
                driver.findElement(By.xpath("//input[@name]")).sendKeys(login);

                driver.findElement(By.xpath("//input[@type='password']/..")).click();
                driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

                driver.findElement(By.xpath("//button[./*[text()='Войти']]")).click();
                Assertions.assertTrue(waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(signInButtonLocator)))),"Error33");


            }

//
//    @BeforeEach
//   private void driverMiximize() {
//        driver = new DriverFactory().create();
//        logger.info("Driver installation");
//        waitTools = new WaitTools(driver);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        driver = new ChromeDriver(options);
////        driver.get(baseUrl);
//        driver.get("https://otus.ru");
//        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        logger.info("Opening the browser in full window mode");
//    }
//    @AfterEach
//    public void driverStop() {
//        if (driver != null) {
//            logger.info("Close browser");
//            driver.close();
//            driver.quit();
//        }
//    }
//    @Test
//    public void openMaximaze() {
////     Нажимаем кнопку Войти на главной странице
//        WebElement elEnter = driver.findElement(By.xpath("//button[text()='Войти']"));
//        elEnter.click();
////     На странице регистрации находим и кликаем поле Электронная почта
//        WebElement elFocus = driver.findElement(By.xpath("//input[@name]/.."));
//        elFocus.click();
////     Вводим email в поле Электронная почта
//        WebElement elEmail = driver.findElement(By.xpath("//input[@name]"));
//        elEmail.sendKeys("login");
////     На странице регистрации находим и кликаем поле Пароль
//        elFocus = driver.findElement(By.xpath("//input[@type='password']/.."));
//        elFocus.click();
////     Вводим пароль в поле Пароль
//        WebElement elPassword = driver.findElement(By.xpath("//input[@type='password']"));
//        elPassword.sendKeys("password");
////     Нажимаем кнопку Войти
//        elEnter = driver.findElement(By.xpath("//button[./*[text()='Войти']]"));
//        elEnter.click();
//        System.out.println("Cookies: " + driver.manage().getCookies());
//    }

}

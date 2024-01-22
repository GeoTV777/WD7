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
    private String baseUrl = System.getProperty("base.url");

    @BeforeEach
    public void init() {
        driver = new DriverFactory().create();
        logger.info("Driver installation");
        waitTools = new WaitTools(driver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        logger.info("Open browser in maximized");

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
        Assertions.assertTrue(waitTools.waitForCondition(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(signInPopapSelector))),"Error:signInPopapSelector is not visible");

        signInButton.click();

        WebElement authPopapElement = driver.findElement(By.cssSelector(signInPopapSelector));
        Assertions.assertTrue(waitTools.waitForCondition(ExpectedConditions.visibilityOf(authPopapElement)),
                "Error: signInPopapSelector is not visible");

        driver.findElement(By.xpath("//input[@name]/..")).click();
        driver.findElement(By.xpath("//input[@name]")).sendKeys(login);

        driver.findElement(By.xpath("//input[@type='password']/..")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

        driver.findElement(By.xpath("//button[./*[text()='Войти']]")).click();
        Assertions.assertTrue(waitTools.waitForCondition(ExpectedConditions.not
                (ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(signInButtonLocator)))),
                "Error: the element is present");
//     Вывод в лог всех cookie
        System.out.println("Cookies: " + driver.manage().getCookies());

        }
}

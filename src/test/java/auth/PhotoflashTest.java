package auth;

import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import tools.WaitTools;

public class PhotoflashTest {

    private Logger logger = (Logger) LogManager.getLogger("WD7");
    private WebDriver driver;
    private WaitTools waitTools;
    private String baseUrl = System.getProperty("base.urlPfoto");

    @BeforeEach
    private void driverInstallFullscreen() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new DriverFactory().create(options);
        waitTools = new WaitTools(driver);
        driver.get(baseUrl);
        logger.info("Open browser in fullscreen");
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
    public void openFullscreen() {
//      Кликаем картинку
        WebElement elPicture = driver.findElement(By.xpath("//li[contains(@data-id,'id-1')]//a"));
        elPicture.click();
//      Проверяем открытие картинки в модальном окне
        WebElement elModalPicture = driver.findElement(By.cssSelector(".pp_content"));
        Assertions.assertTrue(elModalPicture.isDisplayed(),"No image in modal window");
    }

}

//package auth;
//
//import factory.DriverFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import tools.WaitTools;
//
//public class PhotoflashTest {
//
//    private Logger logger = (Logger) LogManager.getLogger("WD7");
//    private WebDriver driver;
//    private WebDriverWait webDriverWait;
//    private WaitTools waitTools;
////    private String baseUrl = System.getProperty("base.url1");
//
//
//    @BeforeEach
//    private void driverInstallFullscreen() {
//        driver = new DriverFactory().create();
//        logger.info("Driver installation");
//        waitTools = new WaitTools();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-fullscreen");
//        driver = new ChromeDriver(options);
//        driver.get("https://p.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
////        driver.get(baseUrl);
//        logger.info("Open browser in fullscreen");
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
//    public void openFullscreen() {
////      Переходим на сайт:
////      Кликаем картинку
//        WebElement elPicture = driver.findElement(By.xpath("//li[contains(@data-id,'id-1')]//a"));
//        elPicture.click();
////      Проверяем открытие картинки в модальном окне
//        WebElement elModalPicture = driver.findElement(By.cssSelector(".pp_content"));
//        Assertions.assertTrue(elModalPicture.isDisplayed(),"No image in modal window");
//    }
//
//}

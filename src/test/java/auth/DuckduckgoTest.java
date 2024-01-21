//package auth;
//
//import factory.DriverFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import tools.WaitTools;
//
//public class DuckduckgoTest {
//    private Logger logger = (Logger) LogManager.getLogger("WD7");
//    private WebDriver driver;
//    // не получается с урлами ну никак!
////    private String baseUrl = System.getProperty("base.url2");
//    private WebDriverWait webDriverWait;
//    private WaitTools waitTools;
//
//
//    @BeforeEach
//    private void driverInstallHeadless() {
//        driver = new DriverFactory().create();
//        logger.info("Driver installation");
//        waitTools = new WaitTools();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
//        driver.get("https://duckduckgo.com");
////        driver.get(baseUrl);
//        logger.info("Open browser in headless");
//    }
//
//    @AfterEach
//    public void driverStop() {
//        if  (driver != null) {
//            logger.info("Close browser");
//            driver.close();
//            driver.quit();
//        }
//    }
//
//    @Test
//
//    public void duckduckHeadless() {
//
//        WebElement elEnter = driver.findElement(By.cssSelector("#searchbox_input"));
//        elEnter.click();
////      В поисковой строке вводим "ОТУС" и кликаем по нему
//        WebElement elInput = driver.findElement(By.cssSelector("#searchbox_input"));
//        elInput.sendKeys("ОТУС");
//        elEnter.submit();
////      В открывшемся окне проверяем, что в поисковой выдаче первый результат
////      Онлайн‑курсы для профессионалов,дистанционное обучение
//
//        WebElement elResult = driver.findElement(By.xpath("//span[contains(text(),'Онлайн‑курсы для профессионалов, дистанционное обучение современным ...')]"));
//        Assertions.assertTrue(elResult.getText().contains("Онлайн‑курсы для профессионалов, дистанционное обучение"),
//                "В поисковой выдаче нет данного текста");
//    }
//}

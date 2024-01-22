package factory;

import exception.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverFactory {

    private String browserName = System.getProperty("browser.name","chrome");

    public WebDriver create(ChromeOptions options) {
        browserName = browserName.toLowerCase();
        switch (browserName){
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(options);
            }
        }
        throw new BrowserNotSupportedException(browserName);
    }
}

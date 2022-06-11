package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> INSTANCE = new InheritableThreadLocal<>();

    public static WebDriver getChromeDriver() {
        if(null==INSTANCE.get()){

            System.setProperty("webdriver.chrome.driver", "driver" + File.separator+"chromedriver.exe");
            INSTANCE.set(new ChromeDriver());
        }
        return INSTANCE.get();

    }
}
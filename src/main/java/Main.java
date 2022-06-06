import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args){
        String driverPath = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.get("https://makeup.com.ua/ua/");


        driver.close();
        driver.quit();
    }
}

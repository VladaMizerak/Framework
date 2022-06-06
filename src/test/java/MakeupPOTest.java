import bo.MakeupBO;
import factory.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class MakeupPOTest {

    private ThreadLocal<WebDriver> driver=
            new InheritableThreadLocal<>();

    @DataProvider(parallel = true)
    public static Object[][] testDataProvider() {
        System.setProperty("webdriver.chrome.driver", "driver" + File.separator+"chromedriver.exe");

        return new Object[][]{
                {"user_1"},
                {"user_2"}
        };
    }

    @Test(dataProvider = "testDataProvider")
    void LoginTest(){
        driver.set(new ChromeDriver());

        MakeupBO shop = new MakeupBO(driver.get());
        //step 1 go to site
        shop.goToHome();

        //step 2 click Log in button
        shop.signIn();

        //step 3 verify i am on demo page
        shop.verifySignInPageIsOpen();

        //step 4 insert login and password
        shop.putLogin("mizerak.vlada@gmail.com", "kudravaya2002");
    }

    @Test
    void SearchProductTest(){
        WebDriver driver = BrowserFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MakeupBO shop = new MakeupBO(driver);

        //step 1 go to site
        shop.goToHome();

        //step 2 Search button
        shop.searchProduct("The ordinary");

        //step 3 click search icon
        shop.allResults();

        //step 4 verify results are displayed
        shop.verifyResults();

    }


    @Test
    void AddProductToCart(){
        WebDriver driver = BrowserFactory.getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MakeupBO shop = new MakeupBO(driver);

        //step 1 go to site
        shop.goToHome();

        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,1000)");

        //step 2 click product
        shop.clickProduct();

        //step 3 click but button
        shop.AddProductCart();

        //step 3 verify product is added
        shop.cartLabel();
    }

    @Test
    void DeleteProductFromCart(){
        WebDriver driver = BrowserFactory.getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MakeupBO shop = new MakeupBO(driver);

        //step 1 go to site
        shop.goToHome();

        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,1000)");

        //step 2 click cart
        shop.clickCart();

        //step 3 click delete icon
        shop.DeleteProduct();

        //step 3 verify cart is empty
        shop.CartIsEmpty();

    }




    @AfterTest
    void closeDriver(){

        //driver.close();
        driver.get().quit();

    }
}

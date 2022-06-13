import bo.MakeupBO;
import factory.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(ListenerTest.class)

public class MakeupTest {

    WebDriver driver = BrowserFactory.getChromeDriver();
    MakeupBO shop = new MakeupBO(driver);

    @Test
    void LoginTest(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

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


//    @Test
//    void filterCategoryMobile() throws InterruptedException {
//        WebDriver driver = BrowserFactory.getChromeDriver();
//        Dimension dimension = new Dimension(414, 896);
//        driver.manage().window().setSize(dimension);
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        MakeupBO shop = new MakeupBO(driver);
//
//        //step 1 go to site
//        shop.goToHome();
//
//        //step 2 click menu
//        shop.clickMenu();
//
//        //step 3 click category
//        shop.clickCategory();
//
//        //step 4 click filter
//        shop.clickFilter();
//
//        //step 5 choose filter
//        shop.chooseFilter();
//
//        //step 6 click button apply
//        shop.clickApply();
//
//        //step 7 verify category is filtered
//        shop.seeFilter();
//    }

    @AfterTest
    void closeDriver(){

        WebDriver driver = BrowserFactory.getChromeDriver();

       driver.close();
       driver.quit();

    }


}

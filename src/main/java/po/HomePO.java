package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePO {

    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHome() {
        driver.get("https://makeup.com.ua/ua/");
    }

    public SignInPO clickLogin() {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[1]/div/div[3]/div")).click();
        return new SignInPO(driver);
    }
//
//    public FeedbackPO clickFeedback(){
//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div[1]/div[2]")).click();
//        return new FeedbackPO(driver);
//    }



    public SearchPO insertProduct(String inputText){
        driver.findElement(By.xpath("//*[@id=\"search-input\"]")).sendKeys(inputText);
        return new SearchPO(driver);
    }

    public AddProductPO clickProduct() {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/div[2]/div[1]/ul/li[2]")).click();
        return new AddProductPO(driver);
    }

    public CartPO ClickCart(){
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div[2]/div[1]/div/span")).click();
        return new CartPO(driver);
    }

    public FilterPO clickMenu() {
        driver.findElement(By.xpath("//*[@id=\"menu-toggle\"]")).click();
        return new FilterPO(driver);
    }
}


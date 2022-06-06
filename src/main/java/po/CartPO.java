package po;

import decorator.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPO {

    private static WebDriver driver;

    public CartPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new FieldDecorator(driver), this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div[2]/ul/li/div[2]/div/div[2]")
    private WebElement delete;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div[1]")
    private WebElement title;

    public void DeleteProduct(){
        delete.click();
    }

    public boolean CartCheck(){ return title.isEnabled();}

}

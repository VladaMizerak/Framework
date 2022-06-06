package po;

import decorator.Button;
import decorator.FieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.Buffer;

public class AddProductPO {

    private static WebDriver driver;

    public AddProductPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new FieldDecorator(driver), this);
    }


    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[2]/div[1]/div/div[3]/div[3]/div[1]")
    private Button buy;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div[2]/ul/li[1]/div[2]/div/a/div[1]")
    private WebElement name;

    public void AddProduct(){ buy.myClick();}
    public boolean CartCheck(){
        return name.isDisplayed();
    }



}

package po;

import decorator.Button;
import decorator.FieldDecorator;
import decorator.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPO {

    private static WebDriver driver;
    public SearchPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new FieldDecorator(driver), this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[2]/div/div[2]/div[2]/form/button[1]")
    private Button search;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/h1")
    private WebElement resultList;


    public void Results(){
        search.myClick();
    }

    public boolean ResultCheck(){
        return resultList.isDisplayed();
    }
}

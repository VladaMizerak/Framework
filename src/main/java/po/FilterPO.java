package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import decorator.Button;
import decorator.FieldDecorator;
import decorator.Element;

import java.awt.*;

public class FilterPO {

    private static WebDriver driver;
    public FilterPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new FieldDecorator(driver), this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/nav/div[4]/ul/li[2]/a")
    private Button clickCategory;

    @FindBy(xpath = "/html/body/div[1]/div[1]/nav/div[4]/ul/li[2]/div/div[1]/div[1]/div/a")
    private Button clickSubcategory;

    @FindBy(xpath= "/html/body/div[1]/div[1]/div/div/div[2]/div[1]/div[1]/div/div[1]/span[1]")
    private Button clickFilter;

    @FindBy (xpath = "//*[@id=\"popularinput-checkbox-2243-23957\"]")
    private Button filterChoose;

    @FindBy (xpath = "/html/body/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/button[2]")
    private Button applyButton;

    @FindBy (xpath = "/html/body/div[1]/div[1]/div/div/div[2]/div[1]/div[1]/div/div[6]/div[1]/label")
    private WebElement verifyFilter;

    public void clickCategoty() {
        clickCategory.myClick();
        clickSubcategory.myClick();
    }

    public void clickFilter() {
        clickFilter.myClick();
    }

    public void chooseFilter() {
        filterChoose.myClick();
    }

    public void clickApply() {
        applyButton.myClick();
    }

    public boolean seeFilter() {
        return verifyFilter.isEnabled();
    }
}

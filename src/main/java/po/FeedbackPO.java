package po;

import decorator.Button;
import decorator.Element;
import decorator.FieldDecorator;
import decorator.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPO {

    private static WebDriver driver;

    public FeedbackPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new FieldDecorator(driver), this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[2]/div/div[1]/div[2]")
    private WebElement feedback;

    @FindBy(xpath = "/html/body/form[3]/div/div[2]/h2")
    private WebElement form;

    @FindBy(xpath = "/html/body/form/div/div[2]/div[1]/div/input")
    private Input fieldName;

    @FindBy(xpath = "/html/body/form[3]/div/div[2]/div[2]/div/input")
    private Input fieldNumber;

    @FindBy(xpath = "/html/body/form[3]/div/div[2]/div[3]/div/textarea")
    private Input fieldComment;

    @FindBy(xpath = "/html/body/form[3]/div/div[2]/div[4]/button")
    private Button send;


    public void clickFeedback(){
        feedback.click();
    }

    public boolean FormCheck(){
        return form.isDisplayed();
    }

    public FeedbackPO insertData(java.lang.String name, java.lang.String number, java.lang.String text){
        fieldName.input(java.lang.String.valueOf(name));
        fieldNumber.input(java.lang.String.valueOf(number));
        fieldComment.input(java.lang.String.valueOf(text));
        return this;
    }

    public void SendFeedback(){
        send.myClick();
    }





}

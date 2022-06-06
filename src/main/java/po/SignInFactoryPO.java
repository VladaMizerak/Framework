package po;

import decorator.Button;
import decorator.FieldDecorator;
import decorator.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInFactoryPO {


    @FindBy(xpath = "//*[@id=\"form-auth\"]/div/div[2]/div[1]/div/input")
    private Input loginInput;

    @FindBy(xpath = "//*[@id=\"form-auth\"]/div/div[2]/div[2]/div/input")
    private Input passwordInput;

    @FindBy(xpath= "//*[@id=\"form-auth\"]/div/div[2]/div[3]/button")
    private Button signinButton;


    private WebDriver driver;
    public SignInFactoryPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new FieldDecorator(driver),this);
    }

    public boolean isOpen() {
        return driver
                .findElement(By.xpath("//*[@id=\"form-auth\"]/div/div[2]/h2"))
                .isDisplayed();
    }

    public SignInFactoryPO insertLogin(String userLogin){
        loginInput.input(userLogin);
        return this;
    }

    public SignInFactoryPO insertPassword(String password){
        passwordInput.input(password);
        return this;
    }

    public SignInFactoryPO clickSignUp(){
        signinButton.myClick();
        return new SignInFactoryPO(driver);

    }


}

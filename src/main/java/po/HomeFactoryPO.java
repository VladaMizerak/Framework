package po;

import decorator.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFactoryPO {

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[1]/div/div[3]/div")
    Button signInButton;

    private final WebDriver driver;

    public HomeFactoryPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToHome() {
        driver.get("https://makeup.com.ua/ua/");
    }

    public SignInPO clickSignIn() {
        signInButton.myClick();
        return new SignInPO(driver);

    }
}

package decorator;

import org.openqa.selenium.WebElement;

public class Input extends Element {
    public Input(WebElement webElement) {
        super(webElement);
        this.webElement = webElement;
    }

    public void input(String inputText){
        System.out.println("My input '"+inputText+"' worked");
        webElement.sendKeys(inputText);
    }

}

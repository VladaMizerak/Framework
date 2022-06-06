package decorator;

import org.openqa.selenium.WebElement;

public class Button extends Element{

    public Button(WebElement webElement){
        super(webElement);
        this.webElement=webElement;
    }

    public void myClick(){
        System.out.println("click");
        webElement.click();
    }

}

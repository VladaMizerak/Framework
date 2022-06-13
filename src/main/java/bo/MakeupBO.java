package bo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import po.CartPO;
import po.FilterPO;
import po.HomePO;
import po.SignInPO;
import po.SearchPO;
import po.AddProductPO;
import po.FeedbackPO;


public class MakeupBO {

    private static WebDriver driver;
    private static HomePO homePO;
    private static SearchPO searchPO;
    private static FeedbackPO feedbackPO;
    private static AddProductPO addProductPO;
    private static CartPO cartPO;
    private static SignInPO signInPO;
    private static FilterPO filterPO;

    public static void main(String[] args){

    }

    public MakeupBO(WebDriver driver){
        this.driver=driver;
    }

    public static void goToHome() {
        homePO = new HomePO(driver);
        homePO.goToHome();
    }


    public static void signIn() {
        signInPO = homePO.clickLogin();
    }
    public static void verifySignInPageIsOpen() {
        Assert.assertTrue(signInPO.isOpen());
    }
    public static void putLogin(java.lang.String userLogin, java.lang.String password) {
        signInPO.insertLogin(java.lang.String.valueOf(userLogin), java.lang.String.valueOf( password));
    }



    public static void searchProduct(java.lang.String product) {searchPO = homePO.insertProduct(java.lang.String.valueOf(product));}
    public static void allResults(){searchPO.Results();}
    public static void verifyResults(){Assert.assertTrue(searchPO.ResultCheck());}


    public void clickProduct() { addProductPO = homePO.clickProduct();}
    public void AddProductCart() { addProductPO.AddProduct();}
    public void cartLabel() { addProductPO.CartCheck();}

    public void clickCart() { cartPO = homePO.ClickCart();}
    public void DeleteProduct() { cartPO.DeleteProduct();}
    public void CartIsEmpty() { cartPO.CartCheck();}

    public void clickMenu() { filterPO = homePO.clickMenu();}
    public void clickCategory() { filterPO.clickCategoty();}
    public void clickFilter() { filterPO.clickFilter();}
    public void chooseFilter() { filterPO.chooseFilter();}
    public void clickApply() { filterPO.clickApply();}
    public void seeFilter() { Assert.assertTrue(filterPO.seeFilter());}



}

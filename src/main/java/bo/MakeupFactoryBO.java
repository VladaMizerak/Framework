//package bo;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import po.HomeFactoryPO;
//import po.SignInFactoryPO;
//
//public class MakeupFactoryBO {
//    private static WebDriver driver;
//
//    private HomeFactoryPO homePO;
//
//    public static void main(String[] args){
//    }
//
//    SignInFactoryPO signUpPO;
//
//    public MakeupFactoryBO(WebDriver driver){
//        this.driver=driver;
//    }
//
//    public void goToHome() {
//        homePO = new HomeFactoryPO(driver);
//        homePO.goToHome();
//    }
//
//    public void signIn() {
//        signUpPO = homePO.clickSignIn();
//    }
//
//    public void verifySignInPageIsOpen() {
//        Assert.assertTrue(signUpPO.isOpen());
//    }
//
//    public void putLogin(String userLogin) {
//        signUpPO
//                .insertLogin(userLogin)
//                .clickSignUp();
//    }
//}

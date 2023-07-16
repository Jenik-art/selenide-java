package Selenide.page_object;

import org.testng.Assert;
import org.testng.annotations.Test;


import static Selenide.page_object.WebDriverContainer.getDriver;


public class LoginTest extends TestBase{

    private static String correctEmail = "ducklover@gmail.com";
    private static String incorrectEmail = "adsfdf@adsf.com";
    private static String correctPassword = "Test12345";
    private static String incorrectPassword = "adfadsf";



    @Test
    public static void loginWithValidCredentials(){
        String expectedMessage = "You are now logged in as Evgeny Art.";

        LoginPage.attemptLogin(correctEmail,correctPassword);

        Assert.assertEquals(LoginPage.getSuccessMessageText(getDriver()),expectedMessage);
    }

    @Test
    public static void loginWithInvalidEmail(){
        String expectedMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage.attemptLogin(incorrectEmail,correctPassword);

        Assert.assertEquals(LoginPage.getErrorMessageText(getDriver()),expectedMessage);
    }

    @Test
    public static void loginWithInvalidPassword(){
        String expectedMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage.attemptLogin(correctEmail,incorrectPassword);
        Assert.assertEquals(LoginPage.getErrorMessageText(getDriver()),expectedMessage);
    }

//    To ask: could I override attemptLogin method here
//    @Test
//    public static void loginWithInvalidNoPassword(){
//        String expectedMessage = "You must provide both email address and password.";
//
//        LoginPage.attemptLogin(getDriver(),correctEmail);
//        Assert.assertEquals(LoginPage.getErrorMessageText(getDriver()),expectedMessage);
//    }

}

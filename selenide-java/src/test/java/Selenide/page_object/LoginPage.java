package Selenide.page_object;
import Selenide.page_object.locators.Locators;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Selenide.page_object.WebDriverContainer.getDriver;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static By emailInput = Locators.getLocator("LoginPage.emailInput");
    private static By passwordInput = Locators.getLocator("LoginPage.passwordInput");
    private static By loginButton = Locators.getLocator("LoginPage.loginButton");
    private static By successMessage = Locators.getLocator("LoginPage.successMessage");
    private static By errorMessage = Locators.getLocator("LoginPage.errorMessage");

    public static By getSuccessMessageLocator() {
        return successMessage;

    }

    public static void attemptLogin(String email, String password){
        $(emailInput).sendKeys(email);
        $(passwordInput).sendKeys(password);
        $(loginButton).click();
    }

    public static String getErrorMessageText(WebDriver driver){
        $(errorMessage).should(Condition.appear);
        return $(errorMessage).getText();
    }
    public static String getSuccessMessageText(WebDriver driver){
        $(successMessage).should(Condition.appear);
        return $(successMessage).getText();
    }

    public static void waitOfText() {
        String targetValue = " You are now logged in as Evgeny Art.";
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        wait.until(ExpectedConditions.textToBe(LoginPage.getSuccessMessageLocator(), targetValue));


    }


}

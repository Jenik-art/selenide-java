package Selenide.page_object;

import Selenide.page_object.locators.Locators;
import org.openqa.selenium.By;

import static Selenide.page_object.WebDriverContainer.getDriver;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    private static By confirmOrder = Locators.getLocator("CheckoutPage.confirmOrder");
    private static By orderSuccessMsg = Locators.getLocator("CheckoutPage.orderSuccessMsg");

    public static void clickConfirmOrderBtn(){
        $(confirmOrder).click();
    }

    public static String getCompleteOrderingMsg(){
        return $(orderSuccessMsg).getText();
    }

}

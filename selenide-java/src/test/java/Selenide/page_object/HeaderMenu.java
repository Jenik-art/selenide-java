package Selenide.page_object;

import Selenide.page_object.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class HeaderMenu {
    private static By homePageBtn = Locators.getLocator("HeaderMenu.homePageBtn");
    private static By rubberDuckMenuItem = Locators.getLocator("HeaderMenu.rubberDuckMenuItem");
    private static By subcategoryMenuItem = Locators.getLocator("HeaderMenu.subcategoryMenuItem");
    private static By cartLink = Locators.getLocator("HeaderMenu.cartLink");
    private static By totalQuantityOfDucks = Locators.getLocator("HeaderMenu.totalQuantityOfDucks");

    public static void goToRubberDuckPage(WebDriver driver) {
        $(rubberDuckMenuItem).click();
    }


    public static void goToCartPage() {
        $(cartLink).click();
    }

    public static By getQuantityOfPurchaseLocator() {
        return totalQuantityOfDucks;

    }

    public static String getQuantityOfPurchase() {
        return $(totalQuantityOfDucks).getText();
    }
}

package Selenide.page_object;

import Selenide.page_object.locators.Locators;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static Selenide.page_object.WebDriverContainer.getDriver;
import static com.codeborne.selenide.Selenide.$;

public class DuckPage {
    private static By selectSize = Locators.getLocator("DuckPage.selectSize");
    private static By duckQuantity = Locators.getLocator("DuckPage.duckQuantity");
    private static By addToCartBtn = Locators.getLocator("DuckPage.addToCartBtn");
    private static By duckSizeMedium = Locators.getLocator("DuckPage.duckSizeMedium");


    public static void selectMediumSize(){
        Select se = new Select($(selectSize));
        se.selectByValue("Medium");
    }
    public static void clickAddToCartBtn(){
        $(HeaderMenu.getQuantityOfPurchaseLocator()).should(Condition.appear);
        $(addToCartBtn).click();
    }


    public static void waitAnimation() {
        String targetValue = "1";
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        wait.until(ExpectedConditions.textToBe(HeaderMenu.getQuantityOfPurchaseLocator(), targetValue));

    }


}

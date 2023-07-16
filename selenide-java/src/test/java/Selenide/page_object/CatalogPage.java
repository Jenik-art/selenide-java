package Selenide.page_object;

import Selenide.page_object.locators.Locators;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CatalogPage {
    private static By sortByNameBtn = Locators.getLocator("CatalogPage.sortByNameBtn");
    private static By yellowDuck = Locators.getLocator("CatalogPage.yellowDuck");
    public static void clickSortByNameBtn(WebDriver driver){
        $(sortByNameBtn).click();
    }

    public static List<String> getListOfDucksName(WebDriver driver) {
        List<SelenideElement> listOfDucks = $$(".listing-wrapper.products a.link div.name");

        List<String> ducks = listOfDucks.stream()
                .map(n -> n.getText())
                .collect(Collectors.toList());
        return ducks;

    }
    public static List<String> getSortedListOfDucksName(WebDriver driver) {
        List<SelenideElement> listOfDucks = $$(".listing-wrapper.products a.link div.name");
        List<String> ducks = listOfDucks.stream()
                .map(n -> n.getText())
                .collect(Collectors.toList());
        List<String> sortedDucks = ducks;
        Collections.sort(sortedDucks);
        return ducks;

    }
    public static List<SelenideElement> getListOfDucks(WebDriver driver) {
        List<SelenideElement> listOfDucks = $$(".listing-wrapper.products a.link div.name");
        return listOfDucks;
    }

    public static void goToYellowDuckSubgroupPage(WebDriver driver){
        $(yellowDuck).click();
    }

}

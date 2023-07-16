package Selenide.page_object;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static Selenide.page_object.WebDriverContainer.getDriver;
import static com.codeborne.selenide.Selenide.$;

public class CatalogTest extends TestBase {
    private static String correctEmail = "ducklover@gmail.com";
    private static String incorrectEmail = "adsfdf@adsf.com";
    private static String correctPassword = "Test12345";
    private static String incorrectPassword = "adfadsf";
    private static String url = "https://litecart.stqa.ru/en/";



    @Test
    public static void sortByNameTest(){
        LoginPage.attemptLogin(correctEmail,correctPassword);
        HeaderMenu.goToRubberDuckPage(getDriver());
        List<String> expectedSorting = CatalogPage.getSortedListOfDucksName(getDriver());
        CatalogPage.clickSortByNameBtn(getDriver());
        List<String> actualSorting = CatalogPage.getListOfDucksName(getDriver());
        Assert.assertEquals(actualSorting,expectedSorting);
    }
    @Test
    public static void openYellowDuckPage(){
        String pageTitleExpected = "Yellow Duck | Subcategory | Rubber Ducks | My Store";
        LoginPage.attemptLogin(correctEmail,correctPassword);
        HeaderMenu.goToRubberDuckPage(getDriver());
        CatalogPage.clickSortByNameBtn(getDriver());
        CatalogPage.goToYellowDuckSubgroupPage(getDriver());

        Assert.assertEquals(Selenide.title(),pageTitleExpected);
    }

}

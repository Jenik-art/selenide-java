package Selenide.page_object;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    protected static String url = "https://litecart.stqa.ru/en/";
    @BeforeTest
    public static void setup(){
        Configuration.baseUrl = url;
        Configuration.pageLoadTimeout = 5000;
        Configuration.browser = "chrome";
        open(url);
    }

}

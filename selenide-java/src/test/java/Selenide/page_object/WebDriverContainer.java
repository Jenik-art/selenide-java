package Selenide.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverContainer {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        Browser browser = Browser.getEnumByLabel(System.getProperty("browser", Browser.CHROME.getBrowserName()));


//        switch (browser){
//            case CHROME -> driver = new ChromeDriver();
//            case SAFARI -> driver = new SafariDriver();
//            case FIREFOX -> driver = new FirefoxDriver();
//        }

        //driver.manage().window().maximize();
    }

        public static void quiteDriver(){
            driver.quit();
            driver = null;
        }
}


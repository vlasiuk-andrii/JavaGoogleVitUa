package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageObject.GoogleBasePage;
import pageObject.SearchPage;

import java.io.IOException;

public class GoogleTest {
    WebDriver driver;

    @BeforeTest
    public void testShutUp(){
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void testShutDown(){
        driver.close();
    }

    @Test
    public void googleSearchTest() throws IOException {
        GoogleBasePage onGoogleBasePage = new GoogleBasePage(driver);
        onGoogleBasePage.getBasePage("http://google.com");
        onGoogleBasePage.inputSearchField("осциллограф");
        onGoogleBasePage.pressSearch();

        SearchPage onSearchPage = new SearchPage(driver);
        onSearchPage.findLinkOnPages("//cite[contains(text(),\"vit.ua\")]");

        //1. Input info in test! not in pageObject. - done
        //2. Screenshot full color                  - done
        //3. Add PageFactory
    }

}

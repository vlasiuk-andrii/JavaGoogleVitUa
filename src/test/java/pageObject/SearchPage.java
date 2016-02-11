package pageObject;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchPage {
    public SearchPage(WebDriver ldriver){
        this.driver = ldriver;
    }

    WebDriver driver;
    //private final Wait<WebDriver> wait = new WebDriverWait(driver, 5).withMessage("Element was not found");

    public boolean searchLinkOnCurrentPage(String xPath){
        boolean result = true;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));

        try{
            driver.findElement(By.xpath(xPath));
        } catch (NoSuchElementException e){
            result = false;
        }
        if (result==true){ return result; }

            try{
                driver.findElement(By.xpath(".//*[@id='pnnext']/span[1]")).click();
            } catch (NoSuchElementException e1){
                System.out.println("Link wasn't found on all pages of google.com");
            }
        return result;
    }


    public void findLinkOnPages(String xPath) throws IOException {
        boolean localResult = false;
        int i = 0;
        do { localResult = searchLinkOnCurrentPage(xPath);
            i++;
            if (localResult==true){break;}
            System.out.println("No result on page №"+i);
        } while (localResult==false);
        driver.manage().window().maximize();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\Users\\andrey.prudnyk\\IdeaProjects\\GoogleVitUa\\GoogleScreenshot.png"));
        System.out.println("Link Vit.ua was found on page №"+i);

    }
}

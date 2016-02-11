package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class GoogleBasePage {
    public GoogleBasePage(WebDriver ldriver){
        this.driver = ldriver;
    }
    WebDriver driver;


    public void getBasePage(String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void inputSearchField(String searchWord){
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(searchWord);
    }

    public void pressSearch(){
        driver.findElement(By.xpath(".//*[@id='sblsbb']/button")).click();
    }



}

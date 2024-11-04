package concepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//locators

public class Locators {
    public static String browser ="chrome"; //External configuration - CSV or XLS
    public static WebDriver driver;

    public static void main(String[] args) {
        //understand webdriver interface

        if(browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }else if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }


        driver.get("https://www.selenium.dev/documentation/webdriver/elements/locators/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("Testing");
        driver.findElement(By.partialLinkText("Overview")).click();

        driver.close();

    }
}
package concepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics {


    public static void main(String[] args) {

        //manual older technique

//        System.setProperty("webdriver.chrome.driver","C:\\drive\\chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();

        //better approach where driver is not installed locally instead dependency will take care of it.

        WebDriverManager.chromedriver().create();
        ChromeDriver driver = new ChromeDriver();


        driver.get("http://www.ebay.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("mobile");
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        driver.close();

    }
}

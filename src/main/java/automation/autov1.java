package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class autov1{
    public static void main(String[] args) {
        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.addArguments("--headless"); // Optional: Run in headless mode
        options.addArguments("--disable-gpu");

        // Set up WebDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Open the URL
            String url = "https://rtp.pixika.ai/v2/pdf/index.php?tt=1733996851&product=DIYCALENDAR&source=cam&objectKey=67572defac8fe0fe5&preview=stitch-done%27";
            System.out.println("DEBUG: Opening the URL");
            driver.get(url);

            // Wait for the page to load
            Thread.sleep(5000);
            System.out.println("DEBUG: Page loaded successfully");

            // Locate the FEB month name element
            WebElement febMonthElement = driver.findElement(By.xpath("//*[@id='hub_2']/div[1]/div/div[1]/div[1]"));
            System.out.println("DEBUG: Located the FEB month name element");

            // Locate the parent div element
            WebElement parentElement = driver.findElement(By.xpath("//*[@id='hub_2']/div[1]/div"));
            System.out.println("DEBUG: Located the parent div element");

            // Remove padding for FEB month element
            System.out.println("DEBUG: Removing padding for FEB month name element");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.padding = '0px';", febMonthElement);

            // Measure the distance between the FEB month element and the parent div
            int febY = febMonthElement.getLocation().getY();
            int parentY = parentElement.getLocation().getY();
            int distance = febY - parentY;

            // Print the distance
            System.out.println("DEBUG: Distance between FEB month name and parent div: " + distance + " px");

            // Validate bleed measurement
            if (distance >= 57 && distance <= 59) {
                System.out.println("Bleed measure is correct!");
            } else {
                System.out.println("Bleed measure is incorrect. Distance measured: " + distance + " px");
            }

        } catch (Exception e) {
            System.out.println("ERROR: An exception occurred - " + e.getMessage());
        } finally {
            // Close the browser
            System.out.println("DEBUG: Closing the browser");
            driver.quit();
        }
    }
}

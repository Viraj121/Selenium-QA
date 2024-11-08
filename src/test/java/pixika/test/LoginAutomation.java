import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {

    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with the path to your chromedriver

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Open the login page
        String url = "https://yourwebsite.com"; // Replace with your actual URL
        driver.get(url);

        try {
            // Wait for the page to load
            Thread.sleep(3000);

            // Locate username field and enter text
            driver.findElement(By.xpath("/html/body/div/form/div[1]/input")).sendKeys("cv001");

            // Locate password field and enter text
            driver.findElement(By.xpath("/html/body/div/form/div[2]/input")).sendKeys("indigital");

            // Locate login button by CSS selector and click it
            driver.findElement(By.cssSelector("#loginButton")).click();

            // Wait for 2000 seconds to observe the output
            Thread.sleep(2000 * 1000);

        } catch (InterruptedException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

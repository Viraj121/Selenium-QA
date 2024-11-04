package concepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class relative_locator {
    public static String browser ="chrome";
    public static WebDriver driver;

    public static void main(String[] args) {

        if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        // relative locator

        driver.get("https://www.saucedemo.com/");
        // Find the password field
        WebElement passwordField = driver.findElement(By.id("password"));

        // Use RelativeLocator to find the username field (above the password field)
        WebElement usernameField = driver.findElement(with(By.tagName("input")).above(passwordField));

        // Input text into the username field
        usernameField.sendKeys("standard_user");

        // Use RelativeLocator to find the login button (below the password field)
        WebElement loginButton = driver.findElement(with(By.tagName("input")).below(passwordField));

        // Input password and click login
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Add a delay to allow time for click to process
        try {
            Thread.sleep(3000); // Wait for 3 seconds before closing the browser
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.close();

    }
}

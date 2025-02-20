package concepts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;

public class Frames {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().create();
        ChromeDriver driver = new ChromeDriver();

                try {
                    // Navigate to the W3Schools page
                    driver.get("https://www.w3schools.com/Jsref/tryit.asp?filename=tryjsref_alert");

                    // Maximize the browser window
                    driver.manage().window().maximize();

                    // Switch to the iframe containing the "Try it" editor
                    driver.switchTo().frame("iframeResult");

                    // Locate the "Try it" button and click it
                    WebElement tryItButton = driver.findElement(By.tagName("button"));
                    tryItButton.click();

                    // Handle the alert
                    Alert alert = driver.switchTo().alert();

                    // Print the alert text
                    System.out.println("Alert Text: " + alert.getText());

                    // Accept the alert (click OK)
                    alert.accept();
                    System.out.println("Alert accepted.");

                    // Switch back to the main content (if needed)
                    driver.switchTo().defaultContent();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // Close the browser
                    driver.quit();
                }
            }
        }
package concepts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

    public class SauceDemoTest {
        public static void main(String[] args) throws IOException {
            // 1️⃣ Set up the WebDriver for Chrome
            System.setProperty("web-driver.chrome.driver", "C:\\path\\to\\chromedriver.exe"); // Change the path as per your setup
            WebDriver driver = new ChromeDriver();

            // 2️⃣ Maximize the browser window
            driver.manage().window().maximize();

            // 3️⃣ Set implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            try {
                // 4️⃣ Open the SauceDemo login page
                driver.get("https://www.saucedemo.com/");
                System.out.println("Opened SauceDemo website.");

                // 5️⃣ Verify the page title
                String pageTitle = driver.getTitle();
                System.out.println("Page Title: " + pageTitle);
                if (!pageTitle.contains("Swag Labs")) {
                    throw new RuntimeException("Incorrect Page Title!");
                }

                // 6️⃣ Locate and fill in the username and password fields
                WebElement username = driver.findElement(By.id("user-name"));
                WebElement password = driver.findElement(By.id("password"));
                username.sendKeys("standard_user");
                password.sendKeys("secret_sauce");

                // 7️⃣ Click the Login button
                WebElement loginButton = driver.findElement(By.id("login-button"));
                loginButton.click();

                // 8️⃣ Verify login success by checking the presence of a logout button
                WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
                if (menuButton.isDisplayed()) {
                    System.out.println("Login Successful!");
                } else {
                    throw new RuntimeException("Login Failed!");
                }

                // 9️⃣ Sorting products using the dropdown
                WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
                Select select = new Select(sortDropdown);
                select.selectByValue("hilo"); // Select "Price (high to low)"
                System.out.println("Products sorted by price (High to Low)");

                // 🔟 Adding an item to the cart
                WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
                addToCartButton.click();
                System.out.println("Item added to cart.");

                // 1️⃣1️⃣ Navigating to the cart
                WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
                cartIcon.click();
                System.out.println("Navigated to the cart.");

                // 1️⃣2️⃣ Taking a screenshot of the cart page
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("cart_screenshot.png"));
                System.out.println("Screenshot taken.");

                // 1️⃣3️⃣ Handling Browser Navigation
                driver.navigate().back(); // Go back to the product page
                System.out.println("Navigated back to products.");
                driver.navigate().forward(); // Move forward to the cart page again
                System.out.println("Navigated forward to cart.");
                driver.navigate().refresh(); // Refresh the page
                System.out.println("Page refreshed.");

                // 1️⃣4️⃣ Explicit Wait (Wait for Logout button to be clickable)
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
                menu.click();

                // 1️⃣5️⃣ Logging out
                WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
                logoutButton.click();
                System.out.println("Successfully logged out.");

            } catch (Exception e) {
                System.out.println("Test Failed: " + e.getMessage());
            } finally {
                // 1️⃣6️⃣ Close the browser
                driver.quit();
                System.out.println("Browser closed.");
            }
        }
    }


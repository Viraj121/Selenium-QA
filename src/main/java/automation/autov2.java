package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class autov2 {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final double DPI = 96.0;
    private static final double MIN_DISTANCE_MM = 13.0;
    private static final String BASE_URL = "https://rtp.pixika.ai/v2/pdf/index.php?tt=1735209761&product=DIYCALENDAR&source=cam&objectKey=67655b0757e577725&preview=stitch-done";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private double convertPixelsToMillimeters(int pixels) {
        return (pixels / DPI) * 25.4;
    }

    private int calculateVerticalDistance(WebElement element1, WebElement element2) {
        return Math.abs(element2.getLocation().getY() - element1.getLocation().getY());
    }

    private void highlightElement(WebElement element) {
        ((ChromeDriver) driver).executeScript("arguments[0].style.border='3px solid red';", element);
    }

    private void scrollToElement(WebElement element) {
        ((ChromeDriver) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Test
    public void verifyElementDistances() {
        driver.get(BASE_URL);

        for (int month = 2; month <= 24; month += 2) {
            String monthXPath = String.format("//*[@id='hub_%d']/div[1]/div/div[1]/div[1]", month);
            String parentXPath = String.format("//*[@id='hub_%d']/div[1]/div", month);

            try {
                WebElement monthElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(monthXPath)));
                WebElement parentElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentXPath)));

                scrollToElement(monthElement);
                highlightElement(monthElement);
                highlightElement(parentElement);

                int pixelDistance = calculateVerticalDistance(monthElement, parentElement);
                double distanceInMM = convertPixelsToMillimeters(pixelDistance);

                System.out.printf("Month %d: Distance = %.2f mm - %s\n", month, distanceInMM,
                        distanceInMM >= MIN_DISTANCE_MM ? "Correct" : "Incorrect");

            } catch (Exception e) {
                System.out.printf("Month %d: Error - %s\n", month, e.getMessage());
            }
        }
    }
}

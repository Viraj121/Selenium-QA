package pixika.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginAutomation {
//    WebDriver driver;

    public static String browser="chrome";
    public  static WebDriver driver;

    @BeforeClass
    public void setUp () {
//        driver = new ChromeDriver();

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

        driver.manage().window().maximize();
        driver.get("https://worlddiabetesday.kribado.com/");
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

    @Test
    public void testLoggingIntoApplication () throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div/form/div[1]/input")).sendKeys("cv001");

        driver.findElement(By.xpath("/html/body/div/form/div[2]/input")).sendKeys("indigital");

        driver.findElement(By.cssSelector("#loginButton")).click();

        // next page

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        WebElement doctorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/form/div/select")));

        new Select(doctorDropdown).selectByVisibleText("yogesh doc");

        driver.findElement(By.xpath("/html/body/div/form/button[1]")).click();


        //next page

        // Wait until the patient name field is visible on the new page
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout

        // Locate and enter patient name
        WebElement patientName = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#patientName")));
        patientName.sendKeys("John Doe");

        // Locate and enter patient age
        WebElement patientAge = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#patientAge")));
        patientAge.sendKeys("30");

        // Locate and select "Male" gender radio button
        WebElement genderMale = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#addPatientForm > div:nth-child(3) > div:nth-child(2) > label")));
        genderMale.click();

       // Locate and click the submit button
        WebElement submitButton = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#addPatientForm > button")));
        submitButton.click();

        WebElement Question1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"waistOptionsMale\"]/div[1]/label")));
        Question1.click();

        WebElement Question2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"healthForm\"]/div[2]/div[1]/label")));
        Question2.click();

        WebElement Question3 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"healthForm\"]/div[3]/div[2]/label")));
        Question3.click();

        WebElement submitButton2 = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submit-button")));
        submitButton2.click();

        WebElement Download = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"captureBtn\"]")));
        Download.click();

        WebElement OkButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[6]/button[1]")));
        OkButton.click();


        WebElement TakeAnotherTest = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"takeAnotherTestBtn\"]")));
        TakeAnotherTest.click();

        Thread.sleep(4000);
    }
}

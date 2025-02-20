package pixika.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

class FormTest {
    WebDriver driver;


    public FormTest() {
        // Set up the WebDriver (make sure to set the correct path to your WebDriver)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://worlddiabetesday.kribado.com/");
    }

    public void login(){
        driver.findElement(By.xpath("/html/body/div/form/div[1]/input")).sendKeys("cv001");

        driver.findElement(By.xpath("/html/body/div/form/div[2]/input")).sendKeys("indigital");

        driver.findElement(By.cssSelector("#loginButton")).click();
    }

    public void testDoctorSelection(List<String> doctors) {

        // Loop through each doctor in the list
        for (String doctor : doctors) {
            // Select doctor from the dropdown
//            WebElement doctorDropdown = driver.findElement(By.id("doctorDropdown"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
            WebElement doctorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/form/div/select")));


            Select selectDoctor = new Select(doctorDropdown);
            selectDoctor.selectByVisibleText(doctor);

            // Click the submit button to proceed to the next page
            driver.findElement(By.xpath("/html/body/div/form/button[1]")).click();


            // Wait for the next page to load (you may adjust this based on your application)
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10));
//            wait.until(ExpectedConditions.urlContains("nextPage"));

            // Exit after completing the first doctor selection
            break;
        }

        // Quit the driver after completing the test for the first doctor
        driver.quit();
    }


    public static void main(String[] args) {
        // Example list of doctors
        List<String> doctors = List.of("Dr. Smith", "Dr. Johnson", "Dr. Brown","yogesh doc");

        // Create an instance of the test and run it
        FormTest formTest = new FormTest();
        formTest.login();
        formTest.testDoctorSelection(doctors);
    }
}

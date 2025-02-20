package pixika.test.DataEntryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class test2 {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String url = "https://forms.pixika.ai/66dacb00793d79b2c/";
        driver.get(url);

        List<String> languages = Arrays.asList("Hindi", "Marathi", "Gujarati", "Punjabi", "Assamese", "Malayalam", "Telugu", "Kannada ", "Orissa", "Bengali", "Tamil");
        List<String> themes = Arrays.asList("Customizable Themes ");
        List<String> plannerSelections = Arrays.asList("Festival Events", "Panchang", "Scientific Events", "Urdu Planner");

        WebElement employeeIdField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[1]/form/div[1]/div[1]/div/input"));
        employeeIdField.sendKeys("8888");


        for (String planner : plannerSelections) {
            for (String theme : themes) {
                for (String language : languages) {
                    // Find and interact with form fields

                    long phoneNumber = 9000000000L + new Random().nextInt(999999999);
                    WebElement mobileNumberField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[1]/form/div[1]/div[2]/div[1]/input"));
                    mobileNumberField.sendKeys(String.valueOf(phoneNumber));

                    // Proceed button
                    WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[1]/form/div[2]/div[2]/a")));
                    proceedButton.click();

                    WebElement doctorName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[2]/div[1]/div/input")));
                    doctorName.sendKeys("John Doe");

                    WebElement birthday = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[2]/div[2]/div/input"));
                    birthday.click();

                    WebElement birthdayDay = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/table/tbody/tr[3]/td[5]/button"));
                    birthdayDay.click();

                    WebElement okButtonBirthday = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/button[2]"));
                    okButtonBirthday.click();

                    WebElement anniversary = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[2]/div[3]/div/input"));
                    anniversary.click();

                    WebElement anniversaryDay = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/table/tbody/tr[4]/td[3]/button"));
                    anniversaryDay.click();

                    WebElement okButtonAnniversary = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/div/button[2]"));
                    okButtonAnniversary.click();

                    WebElement nextButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div/a[2]"));
                    nextButton.click();

                    // Select language and proceed
                    WebElement languageSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//span[text()='%s']", language))));
                    languageSelector.click();

                    WebElement proceedLanguage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div/a[2]")));
                    proceedLanguage.click();

                    // Select theme
                    WebElement themeSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//span[text()='%s']", theme))));
                    themeSelector.click();

                    WebElement themeSelectorProceed = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div/a[2]")));
                    themeSelectorProceed.click();

                    if (theme.equals("Customizable Themes ")) {
                        WebElement customThemeImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form/div[1]/div[7]/div[2]/div[3]/div[1]/img")));
                        customThemeImage.click();

                        WebElement confirmation = wait.until(ExpectedConditions.elementToBeClickable(By.id("nextNavBtn")));
                        confirmation.click();

                        confirmation = wait.until(ExpectedConditions.elementToBeClickable(By.id("nextNavBtn")));
                        confirmation.click();

                        WebElement plannerSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//span[text()='%s']", planner))));
                        plannerSelector.click();

                        WebElement plannerSelectorNext = wait.until(ExpectedConditions.elementToBeClickable(By.id("nextNavBtn")));
                        plannerSelectorNext.click();

                        if (planner.equals("Panchang")) {
                            WebElement panchangSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Maharashtra']")));
                            panchangSelector.click();
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            WebElement panchangSelectorProceed = wait.until(ExpectedConditions.elementToBeClickable(By.id("nextNavBtn")));
                            panchangSelectorProceed.click();
                        }
                    }

                    // Final approve and create new entry
                    WebElement finalApprove = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/a[1]")));
                    finalApprove.click();

                    WebElement createNewEntry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/a[1]")));
                    createNewEntry.click();
                }
            }
        }

        System.out.println("done");
        driver.quit();
    }
}
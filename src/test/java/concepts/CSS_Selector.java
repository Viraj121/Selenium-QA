package concepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSS_Selector {
    public static String browser="edge";
    public  static WebDriver driver;

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


        driver.get("https://www.salesforce.com/in/form/sem/salesforce-crm/?d=7013y000002hbRLAAY&nc=7013y000000a9thAAA&utm_source=google&utm_medium=paid_search&utm_campaign=apac_in_alllobcon&utm_content=brand-en-multi-product-search_salesforce-crm_7013y000002hbrlaay_7013y000002hbRLAAY&utm_term=Salesforce&ef_id=Cj0KCQjw4Oe4BhCcARIsADQ0cskM_lIKixM6WSof3qlORmAZRsJsGMMehv1Dl17yqcfFZoe1h-pho5QaAuwEEALw_wcB:G:s&s_kwcid=AL!4720!3!676565784220!e!!g!!salesforce&&ev_sid=3&ev_ln=salesforce&ev_lx=kwd-94920873&ev_crx=676565784220&ev_mt=e&ev_n=g&ev_ltx=&ev_pl=&ev_pos=&ev_dvc=c&ev_dvm=&ev_phy=9062207&ev_loc=&ev_cx=16895847353&ev_ax=137218384684&ev_efid=Cj0KCQjw4Oe4BhCcARIsADQ0cskM_lIKixM6WSof3qlORmAZRsJsGMMehv1Dl17yqcfFZoe1h-pho5QaAuwEEALw_wcB:G:s&url=!https://clickserve.dartsearch.net/link/click%3flid=43700074078535017&ds_s_kwgid=58700008151233901&gad_source=1&gclid=Cj0KCQjw4Oe4BhCcARIsADQ0cskM_lIKixM6WSof3qlORmAZRsJsGMMehv1Dl17yqcfFZoe1h-pho5QaAuwEEALw_wcB&gclsrc=aw.ds");

        

        driver.findElement(By.cssSelector("input[name='UserFirstName']")).sendKeys("Testing");


        //MutiValues Attribute
        driver.findElement(By.cssSelector("input#UserFirstName-9QjV[type='text']")).sendKeys("CSS");

        //Another example of multivalue attribute
        // input#UserPhone-7t1k[type='tel'][required='true']

        //prefix,suffix and sub-string selectors ^,$,*

        driver.findElement(By.cssSelector("input[name^='UserFi']")).sendKeys("prefix");

        // input[name$='LastName']

        // input[name*='erPho']




        try {
            Thread.sleep(2000); // Wait for 3 seconds before closing the browser
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}

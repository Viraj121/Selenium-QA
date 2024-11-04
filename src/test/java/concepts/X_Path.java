package concepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class X_Path {
    public static String browser="chrome";
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

//        driver.findElement(By.xpath("//input[@name=\"UserFirstName\"]")).sendKeys("testing");

        //start-with function in x-path
        driver.findElement(By.xpath("//input[starts-with(@id,'UserLastName')]")).sendKeys("Test121");


        //contains function
        driver.findElement(By.xpath("//input[contains(@name,'pany')]")).sendKeys("random");

        //text function
//        driver.findElement(By.xpath("//a[text()='Privacy Statement']")).click();


        //AND OR operator
        driver.findElement(By.xpath("//input[@type='text' and @name='UserFirstName']")).sendKeys("user111");


        //axes path Parent,Child,Self

        //self
        driver.findElement(By.xpath("//select[@name='CompanyEmployees']//self::select")).sendKeys("1 - 25 employees");

        //parent node targetting

        // //option[@value='9']//parent::select

        //child node targetting
        // //select[@name='CompanyEmployees']//child::option[1]


        //descendant x-path and descentant-self

        //point to all descendant element
        // //div[@class='formContainerV2 parbase section']//descendant::div

        //point to all descentant elements with itself
        // //div[@class='formContainerV2 parbase section']//descendant-or-self::div

        //Ancestor xpath and Ancestor-self

        //ancestor
        // //*[@class='fields-wrapper clearfix']//ancestor::div

        //ancestor-self

        // //*[@class='fields-wrapper clearfix']//ancestor-or-self::div

        //following and following-sibling

        // //option[@value='Sales_Manager_AP']//following-sibling::option
        
        try {
            Thread.sleep(2000); // Wait for 3 seconds before closing the browser
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}

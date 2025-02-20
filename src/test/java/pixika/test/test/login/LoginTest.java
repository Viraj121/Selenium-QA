package pixika.test.test.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pixika.test.base.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginErrorMessage(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("xyz1290");
        loginPage.clickButton();
//        String actualMessage=loginPage.getErrorMessage();
//        Assert.assertTrue(actualMessage.contains("Epic sadface"));
    }
}

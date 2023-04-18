package testsuite;

import browseryfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //username field and enter 'tomsmith' to username
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        //Find password field and enter 'admin123' tp password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        //Find the Login Button element and click
        driver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();
        String expectedMessage = "Your username is invaild!\n" +
                "×";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Password not vaild", expectedMessage, actualMessage);


    }
@Test
 public void verifyTheUsernameErrorMessage(){

            //Enter username
            driver.findElement(By.id("username")).sendKeys("tomsmith1");
            //enter password
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            //click on login
            driver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();
            // verify Secure Area is displayed
            String expectedMessage = "Your username is invalid!\n" + "×";
            WebElement actualTextElement = driver.findElement(By.xpath("//div[@class = 'flash error']"));
            String actualMessage = actualTextElement.getText();
            Assert.assertEquals("User name is invalid ", expectedMessage, actualMessage);
        }
    @Test
    public void verifyThePasswordErrorMessage(){
         //Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
           //enter password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
          //click on login
        driver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();
          // verify Secure Area is displayed
        String expectedMessage = "Your password is invalid!\n" + "×";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class = 'flash error']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Password field is not valid", expectedMessage,actualMessage);
    }
    @After
    public void closeDriver() {
        driver.close();
    }
}






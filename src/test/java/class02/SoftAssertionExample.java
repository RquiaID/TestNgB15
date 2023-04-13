package class02;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertionExample {
    //go to syntax rhms
    // send no credentials and click on login button
    // verify the error message is username can be empty

    // first we need to set up precondition
    public static WebDriver driver;

    @BeforeMethod
    public void SetupBrowser() {
        WebDriverManager.chromedriver().setup();//purpose of this line is to set up our chrome driver we are using it in TestNg because this time we are using dependency of WebDriver manager we are calling it from webDriver manager
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%22");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }

    @Test
    public void testCase() {
        //First I need to find weElement login button and click
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        // get the text error message I am going to inspect the DOM to get the text error
        WebElement error = driver.findElement(By.xpath("//span[text()='Username cannot be empty']"));
        // next step is to get the text and save it in a variable
        String actualError = error.getText();
        // String tha contains my expected error
        String expectedError = "Username cannot be empty";
        //for soft assertion
        SoftAssert soft = new SoftAssert();
        // compare
        soft.assertEquals(actualError, expectedError);

      // login button is displayed or not
        boolean disp = loginBtn.isDisplayed();
        System.out.println(" the state of the displaty login is "+disp);
       // call soft assertion
        soft.assertTrue(disp);
        //passes the result to test case to tell if it is pass or fail, it is going to mark our result depends on previous result it is like final decision depends on result of previous assertions
        // this is a must to do in
        soft.assertAll();

    }

}





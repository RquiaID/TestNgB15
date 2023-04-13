package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic {
    public static WebDriver driver;

    // for this particular test I need
    // preconditions
    @BeforeMethod // we use this method  as precondition to open the browser
    public void setUpBrowser() {
        // in Maven, we don't need to use the path webdriver..ect cuz dependencies took care of it we are usind webdriverManager dependency
        WebDriverManager.chromedriver().setup(); // set up driver
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    // I also need post condition to close down the browser
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);// this is not recommended
        driver.quit();
    }

    // testcase
    // enter the username:Admin
    //enter the password:abracadabra
    //click login button
    //verify that the message invalid credentials is Displayed
    //Verify that password text box is being displayed
    @Test
    public void invalidCredentials() {
        // First step: Locate the webElement username and send keys
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");

        //Second: locate the webElement password and send Keys
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));// finding password through xpath
        password.sendKeys("abracadabra");// send password

        //Third: login button and click login
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='btnLogin']"));// * means All, any tag that has id='btnLogin'
        loginBtn.click();
        // Verify the error by inspecting DOM and locate invalid Credentials
        WebElement error = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        //next I have to extract the error
        String errorMsg = error.getText();
        //check if the error message is correct
        String expectedError = "Invalid credentials"; // if I want the test to fail I can change text


        // is the alternative of if else
        // assert the value
        Assert.assertEquals(expectedError,errorMsg); // we are going to be using this instead of if else
        System.out.println("I am here");

        //check if password text box is displayed which going to return a boolean value
        //IMPORTANT// I need to find password element again because if I don't it will show stale exception which means DOM refreshes after login which mean all elements found will be discarded so, I have to find element again
        // find the element again
        password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        boolean pswrdDisplayed= password.isDisplayed();
        //verify that the text box is displayed
        Assert.assertTrue(pswrdDisplayed);

        }
        //test case will only fail if there is syntax errors or exceptions if we want it to fail completely we use assertion
        // So we will not be using if else because it is just printing out not actually failing the test case, always going to pass even its failing
        // So in this case we use the alternated Assertions


    // we have two assertions in this articular test case if my first assertion passes I will see  System.out.println("I am here"); in the console
    // If it fails the rest of assertions won't execute========> this kind of assertions is call Hard assertion

    }

package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNgExample {
    //test1
    //go to syntax Hrms
    //enter the username and password, verify that you logged in  this is the actual test case
    // close the browser  this is the post condition

   public static WebDriver driver; // I declared this variable that represents an instance of the WebDriver interface. So I dont' have to declare it later


    //pre conditions===> to open the browser
    //  to set implicit wait

    @BeforeMethod // we use this method  as precondition to open the browser
    public void setUpBrowser() {
        // in Maven, we don't need to use the path webdriver..ect cuz dependencies took care of it we are usind webdriverManager dependency
        WebDriverManager.chromedriver().setup(); // set up driver
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    // post condition===> to close the browser
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);// this is not recommended
        driver.quit(); // we don't have to create another  instance of webDriver  because I already declared it globally as static
}

// test case1
// Verify login functionality
    @Test
    public void loginFunctionality(){
        WebElement username= driver.findElement(By.xpath("//input[@name='txtUsername']")); // finding element username through xpath username
        username.sendKeys("Admin");// send username
       WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));// finding password through xpath
       password.sendKeys("Hum@nhrm123");// send password
        WebElement loginBtn=driver.findElement(By.xpath("//*[@id='btnLogin']"));// * means All, any tag that has id='btnLogin'
        loginBtn.click();
    }
    // Now we are integrating selenium to TestNg

    //testCase2
    //Verify that password textbox is displayed on the login page
    @Test
    public void passwordTextBoxVerification(){
        //find the webElement password text box
        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        System.out.println(password.isDisplayed());// Display means shown in the screen, selected means there is a selected button for that
    }
// we are using test cases tools Before and After  which help us organize our code in TestNg and that is the difference between TestNg and Selenium

    //This is a Java code example that uses TestNG testing framework and Selenium WebDriver to perform automated testing on a web application.
    // The code includes two test cases: one to verify the login functionality and another to verify that the password textbox is displayed on the login page.

    //The code uses annotations provided by TestNG to define the pre- and post-conditions for the tests.
    // The @BeforeMethod annotation is used to define the precondition to open the browser and set some properties like maximizing the window size and implicitly waiting for 20 seconds for web elements to load. The @AfterMethod annotation is used to define the post-condition to close the browser.

    //The first test case is named loginFunctionality(). It uses the @Test annotation to indicate that it is a test case.
    // The test case finds the web elements for the username and password fields using their respective XPath locators and then sends the username and password values to them.
    // Finally, it clicks on the login button using its XPath locator to log in to the system.
    //The second test case is named passwordTextBoxVerification().
    // It also uses the @Test annotation to indicate that it is a test case.
    // The test case finds the web element for the password field using its XPath locator and then checks if it is displayed on the login page using the isDisplayed() method.
    // The result is printed to the console using the println() method.
    //Overall, this code example demonstrates how to use TestNG and Selenium WebDriver to automate the testing of a web application.
    // It defines pre- and post-conditions to set up and tear down the testing environment and uses annotations to indicate the test cases.
    // It also demonstrates how to locate web elements using XPath locators and interact with them to perform various tests.



}

package class04;

import org.testng.annotations.*;

public class annotations02 {
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I ma after class");
    }
    @BeforeMethod
    public void before(){
        System.out.println("I am before Method");
    }

    @AfterMethod
    public void after(){

    }
    @Test
    public void TestA() {
        System.out.println("I am test A");
    }

    @Test
    public void TestB() {
        System.out.println("I am test B");
    }
}

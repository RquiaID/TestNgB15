package class04;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener implements ITestListener {


    @Override
    public void onTestSuccess(ITestResult result) {
        // if my test success I want to print
        System.out.println("The test case has passed"+result.getName()); // get the name of the test case result that passed
    }
    @Override
        public void onTestFailure(ITestResult result) {
            System.out.println("the test case has failed");// get the name of the test case result that fail
        }
    }










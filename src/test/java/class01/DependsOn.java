package class01;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void Login(){
        System.out.println(6/0); // this is to fail the test Login method so in the console will show Test ignored
    }
    // the dashboard is depends on login test case if test case failed , we don't want to run the verification

    @Test(dependsOnMethods={"Login"}) // here we write the method to which it depends on and its name, if test pass it will appear in green on l corner in the console, if test fail it won't pass
    public void DashBoardVerification(){
        System.out.println(" After login I am verifying dashboard");

        // FYI: if I remove (dependsOnMethods={"Login"}) in front of @Test DashBoardVerification will still run because it does not depend on Login method anymore
    }
}

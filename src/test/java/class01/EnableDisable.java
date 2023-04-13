package class01;

import org.testng.annotations.Test;

public class EnableDisable {

    @Test(enabled = false)   // this is instead of comment it I make it disable, so it will not print, enable=true is by default
    public void Atest() {
        System.out.println("I am first test case");
    }

    @Test
    public void Btest() {
        System.out.println(" I am the second test case");
    }

    @Test(enabled = false)
    public void Ctest() {
        System.out.println(" I am the third test case");

    }
}

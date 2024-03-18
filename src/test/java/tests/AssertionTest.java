package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {
    public static void main(String[] args) {
        Assert.assertEquals(myCalt(5,5),10);

    }
    public static int myCalt(int a, int b) {
        return a + b;
    }
    @Test
    public void calcTest(){
        Assert.assertThrows(ArithmeticException.class,()->myTest());
    }

    public static int  myTest(){
        return 10/0;
    }
    @Test
    public void failTest(){
        int actualResult = someFunction();
        int expectedResult = 5;
        Assert.assertEquals(actualResult,expectedResult,"My comment");
        Assert.fail("The test is fail....");
    }
    public static int someFunction(){
        return 5;
    }

}

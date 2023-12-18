package TestNGPKG;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Annotation2 {
    @Test(groups = {"Smoke","Regression"})
    public void test4()
    {
        System.out.println("This is Test4");
    }
    @Test(groups = {"Smoke"})
    public void test5()
    {
        System.out.println("This is Test5");
    }
    @Test
    public void test6()
    {
        System.out.println("This is Test6");
    }
    @Test
    public void test7()
    {
        System.out.println("This is Test7");
    }
    @Parameters({"url","userName"})
    @Test
    public void test8(String url, String uname)
    {
        System.out.println("This is Test8");
        System.out.println(url);
        System.out.println(uname);
    }
    @Test
    public void test9()
    {
        System.out.println("This is Test9");
        Assert.assertTrue(false);
    }
}

package TestNGPKG;

import org.testng.annotations.*;

public class Annotation1 {

    @Test
    public void test1()
    {
        System.out.println("This is Test1");
    }
    @Test
    public void test2()
    {
        System.out.println("This is Test2");
    }
    @Test
    public void test3()
    {
        System.out.println("This is Test3");
    }
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("This is before suite- it run only one time");
    }
    @AfterSuite
    public void afterSuite()
    {
        System.out.println("This is after suite- it run only one time");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("This is beforeTest method -  it run before each tests");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("This is afterTest method -  it run after each tests");
    }
    @BeforeClass
    public void beforeClass()
    {
        System.out.println("This is before class- run before each class");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("This is after class- run after each class");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("This is before method- run before each method of same class");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("This is after method- run after each method of same class");
    }

}

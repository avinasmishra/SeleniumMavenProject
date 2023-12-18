package TestNGPKG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept {
    //DataProvider is independent of the testng xml file
   // step1: create dataprovider method then call that method into @Test method
    @Test(dataProvider = "getData")
    public void test8(String url, String uname)
    {
        System.out.println(url);
        System.out.println(uname);
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[3][2];
        data[0][0] = "firstName";
        data[0][1] = "firstPassword";
        //2nd input
        data[1][0] = "secondName";
        data[1][1] = "secondPassword";
        //3rd input
        data[2][0] = "thirdName";
        data[2][1] = "thirdPassword";

        return data;
    }

}


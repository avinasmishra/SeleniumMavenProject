package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AutoSuggitiveDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // auto suggestive dropdown - (a.) provide input for auto suggestive dp (b.) generic locator (c.) store in list (d.) iterate over the list
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(1000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for (WebElement option : options)
        {
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }

        //checking whether element is enable or disable
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }


    }
}

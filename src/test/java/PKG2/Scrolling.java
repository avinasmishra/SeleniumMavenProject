package PKG2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Scrolling {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //window scroll
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);

        //scoll to table inside page
        js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0,500)");

        //sum total count of table value
        List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
        int sum = 0;
        for (int i=0;i< values.size();i++)
        {
            String stringSum = values.get(i).getText();
            sum = sum+Integer.parseInt(stringSum);
        }
        System.out.println("SumValue: "+sum);
        System.out.println(driver.findElement(By.cssSelector("div.totalAmount")).getText());
        int total = Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum,total);

    }
}

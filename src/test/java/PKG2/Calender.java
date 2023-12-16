package PKG2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Calender {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //scrolling to the particular requirements
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#form-field-travel_comp_date")).click();

        //Expected Requirement Date: 28 March
        String month = "March";
        String date = "28";

        //Step1: month find
        while(!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']/span")).getText().contains(month))
        {
            driver.findElement(By.className("flatpickr-next-month")).click();
        }

        //Step2: Grab common attribute//Put into list and iterate
        List<WebElement> days = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
        for(int i=0;i<days.size();i++)
        {
            String day = days.get(i).getText();
            if(day.contains(date))
            {
                days.get(i).click();
                break;
            }
        }
//driver.close();
    }
}
//NOTE: If Year have to select copy paste the step1 change the locator only and mention above the step1

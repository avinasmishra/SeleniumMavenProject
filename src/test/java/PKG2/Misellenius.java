package PKG2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Misellenius {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //1. count total link in the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2. get total count of footer section - limitting the driver
        WebElement footerSection = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerSection.findElements(By.tagName("a")).size());

        //3. get left side footersection link counts
        WebElement leftSideFooter = footerSection.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td/ul"));
        System.out.println(leftSideFooter.findElements(By.tagName("a")).size());

        //4. click on each link of footer section
        List<WebElement> links = leftSideFooter.findElements(By.tagName("a"));
        for(int i=1;i<links.size();i++)
        {
            String controlClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
            leftSideFooter.findElements(By.tagName("a")).get(i).sendKeys(controlClick);

        }
        //goto each tab and display the title - use concept of window Handles
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it =windows.iterator();
        while(it.hasNext() )
        {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}

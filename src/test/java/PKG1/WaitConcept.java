package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.function.Function;


public class WaitConcept {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        //Explicit wait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
        //System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());

        //Fluent Wait
         Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
                 .withTimeout(Duration.ofSeconds(20))
                 .pollingEvery(Duration.ofSeconds(2))
                 .ignoring(NoSuchElementException.class);


        WebElement element = fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed())
                {
                    return driver.findElement(By.xpath("//div[@id='finish']/h4"));
                } else {
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed());

    }
}

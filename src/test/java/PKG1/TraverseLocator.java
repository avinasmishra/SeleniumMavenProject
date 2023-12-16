package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TraverseLocator {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //parent to child traverse
        driver.findElement(By.xpath("//header/div/button[1]")).click();
        Thread.sleep(2000);

        //locator-traverse from sibling to sibling
        driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
        String text = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
        System.out.println("Next Sibling Button: "+text);

        //child to parent traverse
        String CtoPText = driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header")).getText();
        System.out.println("Child To Parent: "+CtoPText);




    driver.close();
    }
}

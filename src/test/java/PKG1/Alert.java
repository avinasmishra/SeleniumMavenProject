package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String name = "Avinash";
        //1. Simple alert OK button only
        driver.findElement(By.name("enter-name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        //once alert pop-up appears then use switchTo().alert() method
        driver.switchTo().alert();
        //want to store alert message
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println("Alert Message: "+alertMsg);
        //accept alert - OK
        driver.switchTo().alert().accept();

        //2. Confirm alert - OK & Cancel both button
        driver.findElement(By.name("enter-name")).sendKeys(name);
        driver.findElement(By.id("confirmbtn")).click();
        //once alert pop-up appears then use switchTo().alert() method
        driver.switchTo().alert();
        //want to store alert message
        String alertMsg1 = driver.switchTo().alert().getText();
        System.out.println("Alert Message: "+alertMsg1);
        //cancel alert - dismiss()
        driver.switchTo().alert().dismiss();

    }
}

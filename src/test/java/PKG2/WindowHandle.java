package PKG2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //perform click operation so that other window open
        driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();

        // use getWindowHandles() method to know how many windows open
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Total windows: "+windows.size());

        //Use Iterator to iterate in each window and also useing .next()
        Iterator<String> it = windows.iterator();
        //[0th]- parentwindow
        String parentId = it.next();
        String childId = it.next();

        //currently window is on 1st tab, now switch to child - using switchTo() method
        driver.switchTo().window(childId);

        String textMsg = driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
        //Please email us at mentor@rahulshettyacademy.com with below template to receive response
        String emailID = textMsg.split("at")[1].trim().split(" ")[0];
        System.out.println("Extracted EmailID: "+emailID);

        //again switch back to parent window
        driver.switchTo().window(parentId);
        driver.findElement(By.cssSelector("input#username")).sendKeys(emailID);


    }
}

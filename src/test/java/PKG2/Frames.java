package PKG2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //1. get total frames in web page
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        //2. switch to frame- 3 ways (a) by index, (b) name/id (c) webElement
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        driver.findElement(By.cssSelector("div#draggable")).click();
        //drag and drop an element
        WebElement source = driver.findElement(By.cssSelector("div#draggable"));
        WebElement target = driver.findElement(By.cssSelector("div#droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(source,target).build().perform();

        //3. comeout of frame to normal window - defaultContext()
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Autocomplete")).click();

    }
}

package PKG2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsMouse {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //actions class
        Actions action = new Actions(driver);
        //mouse over to the element- moveToElement
        action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
        action.moveToElement(driver.findElement(By.xpath("//a[@id='nav_prefetch_yourorders']"))).click().build().perform();

        //right click on mouse- contextClick()
        driver.get("https://the-internet.herokuapp.com/context_menu");
        action.contextClick(driver.findElement(By.id("hot-spot"))).build().perform();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //drag and drop- dragAndDrop()
        driver.get("https://jqueryui.com/droppable/");
        //1. get total frames in web page
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        //2. switch to frame- 3 ways (a) by index, (b) name/id (c) webElement
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        WebElement source = driver.findElement(By.cssSelector("div#draggable"));
        WebElement target = driver.findElement(By.cssSelector("div#droppable"));
        action.dragAndDrop(source,target).build().perform();

    }
}

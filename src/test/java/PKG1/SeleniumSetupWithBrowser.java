package PKG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumSetupWithBrowser {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/practice-project");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        System.out.println();
        System.out.println("Title: " + title);
        System.out.println("CurrentUrl: " + currentUrl);

        /*
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\edgeDriver\\msedgedriver.exe");
        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://rahulshettyacademy.com/practice-project");
        driver1.manage().window().maximize();
        String title1 = driver1.getTitle();
        String currentUrl1 = driver1.getCurrentUrl();
        System.out.println();
        System.out.println("Title: " + title1);
        System.out.println("CurrentUrl: " + currentUrl1);
        */

    }
}
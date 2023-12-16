package PKG2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.time.Duration;
import java.util.List;


public class BrokenLink {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        SoftAssert sa = new SoftAssert();

        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));

        for(WebElement link :links)
        {
            String linkUrl = link.getAttribute("href");

            HttpURLConnection connection = (HttpURLConnection) new URL(linkUrl).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int statusCode = connection.getResponseCode();
            System.out.println(statusCode);
            //soft assestion
            sa.assertTrue(statusCode<400,"This link "+link.getText() + " is broken with status code "+statusCode);

        }
        sa.assertAll();
        driver.close();
    }
}

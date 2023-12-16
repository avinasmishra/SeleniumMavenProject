package PKG2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenSot {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        TakesScreenshot src = (TakesScreenshot)driver;
        File source= src.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\Avinash\\IdeaProjects\\ScreenShot\\auto.png");
        FileUtils.copyFile(source,destination);

    }
}

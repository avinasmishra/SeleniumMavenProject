package StreamClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchFilter {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys("Rice");

        List<WebElement> veggieList = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList = veggieList.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());

        Assert.assertEquals(veggieList.size(),filteredList.size());

    }
}

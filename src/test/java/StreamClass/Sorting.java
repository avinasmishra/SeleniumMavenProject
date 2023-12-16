package StreamClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //SC1: click on colon - value get sort compare with original vs sorted value
        driver.findElement(By.xpath("//tr//th[1]")).click();

        //store value into list
        List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));

        //capture text of all webElement and store in new(original) list using stream()
        List<String> originalList = list.stream().map(s->s.getText()).collect(Collectors.toList());

        //sort on original list of step3 and store into another list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //compare both the list
        Assert.assertTrue(originalList.equals(sortedList));


        //SC2: scan the veg table with getTest - and print the Beans price
        List<Object> price = list.stream().filter(s->s.getText().contains("Beans")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
        //print list
        price.forEach(s->System.out.println(s));

    }
    private static Object getVeggiePrice(WebElement s) {
        String vegPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return vegPrice;
    }
}

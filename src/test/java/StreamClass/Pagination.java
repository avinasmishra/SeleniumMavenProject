package StreamClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //SC1: scan the veg table with getTest - and print the Cherry price while is not present in 1st page
        List<Object> price;

         do
         {
             List<WebElement> name = driver.findElements(By.xpath("//tr//td[1]"));
             price = name.stream().filter(s -> s.getText().contains("Cherry"))
                     .map(s -> getVeggie(s))
                     .collect(Collectors.toList());
             //print price
             price.forEach(s -> System.out.println("Price is: "+s));
             if (price.size() < 1) {
                 driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
             }
         }while (price.size()<1);
    }

   /* Updated Way- same outcome
        do

        {
            List<WebElement> name = driver.findElements(By.xpath("//tr//td[1]"));
            price = name.stream().filter(s -> s.getText().contains("Cherry"))
                    .map(Pagination::getVeggie)
                    .toList();
            //print price
            price.forEach(System.out::println);
            if (price.isEmpty()) {
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        }while (price.isEmpty());
    }
    */

    private static Object getVeggie(WebElement s) {
        String vegPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return vegPrice;
    }
}

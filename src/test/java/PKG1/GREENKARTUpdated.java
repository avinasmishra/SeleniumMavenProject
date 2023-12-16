package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class GREENKARTUpdated {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        //Implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        //step1: item needs - add into array
        String[] itemNeeded = {"Brocolli","Cucumber","Carrot"};

        addItems(driver,itemNeeded);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        driver.findElement(By.className("promoBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());


    }

    public static void addItems(WebDriver driver, String[] itemNeeded)
    {
        int j=0;
        //step2: get all product into a list
        List<WebElement> productsName = driver.findElements(By.xpath("//h4[@class='product-name']"));

        //step3: convert into array to list
        List<String> items = Arrays.asList(itemNeeded);
        //step4: extract each product name from List of productName
        for(int i=0;i<productsName.size();i++)
        {
            String itemName = productsName.get(i).getText();

            //split itemName = remove -1kg: Brocolli - 1 Kg
            String formattedItemName = itemName.split("-")[0].trim();

            if(items.contains(formattedItemName))
            {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j==itemNeeded.length)
                {
                    break;
                }
            }
        }
    }
}

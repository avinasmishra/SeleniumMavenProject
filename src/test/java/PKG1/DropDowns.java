package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;


public class DropDowns {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //static dropdown- it means value are fixed, not changing
        WebElement staticValue = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticValue);
        //select by index
        dropdown.selectByIndex(3);

        WebElement element = dropdown.getFirstSelectedOption();
        System.out.println("Value Selected: "+element.getText());

        //select by visible text
        dropdown.selectByVisibleText("AED");
        WebElement element1 = dropdown.getFirstSelectedOption();
        System.out.println("Value Selected: "+element1.getText());

        //select by value option
        dropdown.selectByValue("INR");
        WebElement element2 = dropdown.getFirstSelectedOption();
        System.out.println("Value Selected: "+element2.getText());


        //2. click on plus icon to increase count of passengers
        driver.findElement(By.id("divpaxinfo")).click();

        int i=1;
        while(i<5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }

//       for(int p=1;p<5;p++)
//        {
//            driver.findElement(By.id("hrefIncAdt")).click();
//        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        String textValue = driver.findElement(By.id("divpaxinfo")).getText();
        System.out.println("Selected Text Message: "+textValue);

        Thread.sleep(2000);

        //3. Dynamic dropdown - may be used indexing
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //from dropdown
        driver.findElement(By.xpath("//a[@value='PAT']")).click();
        Thread.sleep(1000);
        //to option
        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();



    }
}

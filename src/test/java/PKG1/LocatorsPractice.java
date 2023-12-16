package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LocatorsPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String name = "Ram";
        //1. By.ID
        WebElement Username = driver.findElement(By.id("inputUsername"));
        Username.sendKeys(name);

        //2. By.name
        driver.findElement(By.name("inputPassword")).sendKeys("1234");

        //3. By.className
        driver.findElement(By.className("signInBtn")).click();

        //4. css selector -if its class then tagname.classname; for id -> tagname#id
        WebElement error = driver.findElement(By.cssSelector("p.error"));

        String errorMessage = error.getText();
        System.out.println("Error Message: "+errorMessage);

        //5. linkText
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);

        //6. xpath (relative xpath)
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("ram@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("1234554321");
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        String tempMsg = driver.findElement(By.cssSelector("p.infoMsg")).getText();
        System.out.println("Message: "+tempMsg);

        //splitting and storing actual password
        String[] splittedPwd= tempMsg.split("'");

        String password = splittedPwd[1].trim();
        System.out.println("Extracted Password: "+password);

        driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
        Thread.sleep(1000);
        Username.sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(1000);

        //verifying actual & expected outcome
        String expectedResult= "You are successfully logged in.";
        //String actualResult= driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText();
        //7. tagName
        String actualResult= driver.findElement(By.tagName("p")).getText();
        System.out.println("actualRel: "+actualResult);
        Assert.assertEquals(actualResult,expectedResult);

        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
       // driver.close();
    }

}

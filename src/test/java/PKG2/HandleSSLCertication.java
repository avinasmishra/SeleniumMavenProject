package PKG2;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandleSSLCertication {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        //1: SSL Cerificate
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //step2: pass chromeoption object into chromeDriver as argument
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://expired.badssl.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Title: "+driver.getTitle());

        //NOTE:  URL = "https://expired.badssl.com/" is not secure, to bypass SSL certication we use ChromeOptions() class along with
        //setAcceptInsecureCerts(true) method

        //2: Proxy - few website need some special access to run there website //we get proxy details from developer
       /*
        //step1: CREATE ChromeOptions() & Pxoxy() class - which already created
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Proxy pro = new Proxy();
        pro.setHttpProxy("getdetails from developer");
        options.setCapability("proxy",pro);
        WebDriver driver = new ChromeDriver(options);
        */


        //3: Block pop up window - default chromeDriver configures chrome to allow pop up window to disable use below steps
        /*
        //step1: CREATE ChromeOptions() class - which already created
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("download.default_directory","path where you want to save file");
        options.setExperimentalOption("prefs", map);
        WebDriver driver = new ChromeDriver(options);
        */


        //4: set download directory - if we want to download file and save it at particular directory then use below step
        /*
        //step1: CREATE ChromeOptions() class - which already created
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\IdeaProjects\\Software\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        WebDriver driver = new ChromeDriver(options);
        */







    }
}

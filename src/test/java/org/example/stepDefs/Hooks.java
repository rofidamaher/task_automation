package org.example.stepDefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class Hooks {
    public static WebDriver driver = null ;
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));

    @Before
    public static void OpenBrowser() {
        // 1- Bridge
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");

       //WebDriverManager.chromedriver().setup();
        //2 new object
        ChromeOptions options= new ChromeOptions();
        options.addArguments("-remote-allow-origins=*");
        driver = new ChromeDriver();

        // 3- Configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOf( Hooks.driver.findElement(correctRequest.reason())))

        // 4- navigate to url
        driver.navigate().to("https://www.amazon.eg/-/en/");
    }

    @After
    public static void quitDriver () throws InterruptedException
    {
        Thread.sleep(3000);
        driver.quit();
    }

}

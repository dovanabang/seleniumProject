package dovanbang.com;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testLogin {

    private WebDriver driver;
    private static String pathFirefoxDriver = "D:\\selenium\\geckodriver-v0.33.0-win64\\GeckoDriver.exe";
    private static String pathChormeDriver = "D:\\selenium\\chromedriver-win64\\chromedriver.exe";
    public WebDriver getDriver() {
        return driver;
    }


    public void setDriver(String browserType, String webURL) {
        switch (browserType) {
            case "chrome":
                System.out.println("BrowserStack is launched successfully on Chrome!");
                driver = initChromeDriver(webURL);
                break;
            case "gecko":
                System.out.println("BrowserStack is launched successfully on FireFox!");
                driver = initFirefoxDriiver(webURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, We user Chrome");
                driver = initChromeDriver(webURL);
        }

    }

    private WebDriver initChromeDriver(String webURL) {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", pathChormeDriver);
//        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("D:\\selenium\\adblock.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        driver = new ChromeDriver(options);
//        driver.get(webURL);
        driver.navigate().to(webURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initFirefoxDriiver(String webURL) {
//        System.setProperty("webdriver.gecko.driver", pathFirefoxDriver);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
//        driver.get(webURL);
        driver.navigate().to(webURL);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;


    }

    @Parameters({"browserType", "webURL"})
    @BeforeClass
    public void baseSetup(String browserType, String webURL) {
        setDriver(browserType, webURL);
    }

    @AfterClass
    public void endTest() {
        driver.quit();
    }
}

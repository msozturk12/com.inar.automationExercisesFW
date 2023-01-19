package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<WebDriver>();

    public Driver() {

    }

    /**
     * Synchronized makes method thread safe.
     * It ensures that only 1 thread can use it at the time.
     * Thread safety reduces performance but it makes everything safe.
     *
     * @return
     */

    public synchronized static WebDriver getDriver() {
        /*
         * We first check if a webdriver object exists,
         * if not, this method will create it.
         *
         */
        if (driverPool.get() == null) {

            /*
             * We specified the type of browser in the configuration.properties file.
             * And then, we load these information into a Properties class object
             * by initiating a FileInputStream class  object.
             * This is where we will get type of browser by using ConfigurationReader.java class object.
             */

            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    File file = new File("C:\\Seleniumm\\extension_5_3_3_0 (1).crx");
                    chromeOptions.addExtensions(file);
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    Set<String> windowHandles = driverPool.get().getWindowHandles();
                    String lastWindow = windowHandles.toArray()[windowHandles.size()-1].toString();
                    driverPool.get().switchTo().window(lastWindow).close();
                    driverPool.get().switchTo().window(windowHandles.toArray()[0].toString());
                    WebDriverWait wait = new WebDriverWait(driverPool.get(),10);
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Wrong browser name !");
            }


        }
        return driverPool.get();
    }

}

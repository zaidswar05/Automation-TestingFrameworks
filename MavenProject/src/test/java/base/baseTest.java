package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class baseTest {
    protected WebDriver driver;
    protected SoftAssert soft;
    protected final Logger log = LogManager.getLogger(getClass());

    @BeforeMethod
    public void setUp() {
        log.info("Configuring ChromeOptions to prevent browser initialization hangs...");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver = new ChromeDriver(options);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        soft = new SoftAssert();

        log.info("Browser initialized successfully.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            if (soft != null) {
                soft.assertAll();
            }
        } finally {
            if (driver != null) {
                log.info("Terminating browser session.");
                driver.quit();
            }
        }
    }
}
package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    private static String baseUrl;
    private static final Properties properties = TestProperties.getInstance().getProperties();

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);

        driver.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS)
                .setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        baseUrl = properties.getProperty("app.url");
        driver.navigate().to(baseUrl);

    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

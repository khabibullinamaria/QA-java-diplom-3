import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTests {
    protected WebDriver driver;

    protected void InitDriver(String url){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    protected void AssertExists(By elementBy){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        var element = driver.findElement(elementBy);
        Assert.assertNotNull(element);
    }
}

import models.EnterPageStellarBurgers;
import models.MainPageStellarBurgers;
import models.SignInPageStellarBurgers;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInTests {
    private WebDriver driver;

    @Test
    public void signInStellarBurgers() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        objMainPage.clickHeaderPersonalAccountButton();
        // создай объект класса
        EnterPageStellarBurgers objEnterPage = new EnterPageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objEnterPage.signInLink));
        objEnterPage.clickSignInLink();
        // создай объект класса
        SignInPageStellarBurgers objSignInPage = new SignInPageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objSignInPage.signInButton));
        var name = java.util.UUID.randomUUID().toString();
        var email = java.util.UUID.randomUUID() + "@mail.ru";
        var password = java.util.UUID.randomUUID().toString();

        objSignInPage.SignIn(name, email,password);

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objEnterPage.signInLink));

    }

    @After
    public void teardown() {
        driver.quit();
    }
}

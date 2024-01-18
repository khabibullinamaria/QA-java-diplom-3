import io.qameta.allure.Step;
import models.EnterPageStellarBurgers;
import models.ForgotPasswordPageStellarBurgers;
import models.MainPageStellarBurgers;
import models.SignInPageStellarBurgers;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInTests {
    private WebDriver driver;

    @Test
    public void LogInMainPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        objMainPage.clickLogInButtonMainPage();

        LogIn();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objMainPage.createOrderButtonMainPage));
    }

    @Test
    public void LogInFromPersonalAccountButton() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        objMainPage.clickHeaderPersonalAccountButton();

        LogIn();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objMainPage.createOrderButtonMainPage));
    }

    @Test
    public void LogInFromRegistrationForm() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/register");

        SignInPageStellarBurgers singInPage = new SignInPageStellarBurgers(driver);
        singInPage.clickLoginLink();

        LogIn();

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objMainPage.createOrderButtonMainPage));
    }

    @Test
    public void LogInFromForgotPasswordForm() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        ForgotPasswordPageStellarBurgers forgotPasswordPage = new ForgotPasswordPageStellarBurgers(driver);
        forgotPasswordPage.clickLoginLink();

        LogIn();

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objMainPage.createOrderButtonMainPage));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Step("LogIn")
    private void LogIn(){
        EnterPageStellarBurgers objEnterPage = new EnterPageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objEnterPage.signInLink));
        var email = "stynson@mail.ru";
        var password = "itwillbelegendary";
        objEnterPage.logInToAccount(email,password);
    }
}


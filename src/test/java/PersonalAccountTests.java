import io.qameta.allure.Step;
import models.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountTests {
    private WebDriver driver;

    @Test
    public void OpenProfileTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/login");

        LogInAndEnterProfile();

        ProfilePageStellarBurgers profilePage = new ProfilePageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profilePage.profileTab));
    }

    @Test
    public void OpenConstructorTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/login");

        LogInAndEnterProfile();

        MainPageStellarBurgers mainPage = new MainPageStellarBurgers(driver);
        mainPage.clickConstructorLink();

        ConstructorPageStellarBurgers constructorPage = new ConstructorPageStellarBurgers(driver);

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.constructorHeader));
    }

    @Test
    public void OpenConstructorByLogoTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/login");

        LogInAndEnterProfile();

        MainPageStellarBurgers mainPage = new MainPageStellarBurgers(driver);
        mainPage.clickLogo();

        ConstructorPageStellarBurgers constructorPage = new ConstructorPageStellarBurgers(driver);

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.constructorHeader));
    }

    @Test
    public void ExitTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/login");

        LogInAndEnterProfile();

        ProfilePageStellarBurgers profilePage = new ProfilePageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profilePage.exitButton));
        profilePage.clickExitButton();

        EnterPageStellarBurgers enterPage = new EnterPageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(enterPage.logInButton));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Step("LogInAndEnterProfile")
    private void LogInAndEnterProfile(){
        EnterPageStellarBurgers objEnterPage = new EnterPageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objEnterPage.signInLink));
        var email = "stynson@mail.ru";
        var password = "itwillbelegendary";
        objEnterPage.logInToAccount(email,password);

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        objMainPage.clickHeaderPersonalAccountButton();
    }
}


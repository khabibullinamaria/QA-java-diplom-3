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

public class PersonalAccountTests extends BaseTests {

    @Test
    public void OpenProfileTest() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/login");

        LogInAndEnterProfile();

        ProfilePageStellarBurgers profilePage = new ProfilePageStellarBurgers(driver);
        super.AssertExists(profilePage.profileTab);
    }

    @Test
    public void OpenConstructorTest() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/login");

        LogInAndEnterProfile();

        MainPageStellarBurgers mainPage = new MainPageStellarBurgers(driver);
        mainPage.clickConstructorLink();

        ConstructorPageStellarBurgers constructorPage = new ConstructorPageStellarBurgers(driver);

        super.AssertExists(constructorPage.constructorHeader);
    }

    @Test
    public void OpenConstructorByLogoTest() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/login");

        LogInAndEnterProfile();

        MainPageStellarBurgers mainPage = new MainPageStellarBurgers(driver);
        mainPage.clickLogo();

        ConstructorPageStellarBurgers constructorPage = new ConstructorPageStellarBurgers(driver);

        super.AssertExists(constructorPage.constructorHeader);
    }

    @Test
    public void ExitTest() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/login");

        LogInAndEnterProfile();

        ProfilePageStellarBurgers profilePage = new ProfilePageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profilePage.exitButton));
        profilePage.clickExitButton();

        EnterPageStellarBurgers enterPage = new EnterPageStellarBurgers(driver);
        super.AssertExists(enterPage.logInButton);
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


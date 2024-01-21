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

public class LogInTests extends BaseTests{
    @Test
    public void LogInMainPage() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/");

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        objMainPage.clickLogInButtonMainPage();

        LogIn();

        super.AssertExists(objMainPage.createOrderButtonMainPage);
    }

    @Test
    public void LogInFromPersonalAccountButton() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/");

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        objMainPage.clickHeaderPersonalAccountButton();

        LogIn();

        super.AssertExists(objMainPage.createOrderButtonMainPage);
    }

    @Test
    public void LogInFromRegistrationForm() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/register");

        SignInPageStellarBurgers singInPage = new SignInPageStellarBurgers(driver);
        singInPage.clickLoginLink();

        LogIn();

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        super.AssertExists(objMainPage.createOrderButtonMainPage);
    }

    @Test
    public void LogInFromForgotPasswordForm() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/forgot-password");

        ForgotPasswordPageStellarBurgers forgotPasswordPage = new ForgotPasswordPageStellarBurgers(driver);
        forgotPasswordPage.clickLoginLink();

        LogIn();

        MainPageStellarBurgers objMainPage = new MainPageStellarBurgers(driver);
        super.AssertExists(objMainPage.createOrderButtonMainPage);
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


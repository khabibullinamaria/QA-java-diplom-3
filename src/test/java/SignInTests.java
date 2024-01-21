import models.EnterPageStellarBurgers;
import models.MainPageStellarBurgers;
import models.SignInPageStellarBurgers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInTests extends BaseTests{
    @Test
    public void signInStellarBurgers() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/register");

        SignInPageStellarBurgers objSignInPage = new SignInPageStellarBurgers(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(objSignInPage.signInButton));
        var name = java.util.UUID.randomUUID().toString();
        var email = java.util.UUID.randomUUID() + "@mail.ru";
        var password = java.util.UUID.randomUUID().toString();

        objSignInPage.SignIn(name, email,password);

        EnterPageStellarBurgers objEnterPage = new EnterPageStellarBurgers(driver);
        super.AssertExists(objEnterPage.signInLink);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

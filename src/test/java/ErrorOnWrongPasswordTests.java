import models.EnterPageStellarBurgers;
import models.MainPageStellarBurgers;
import models.SignInPageStellarBurgers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(Parameterized.class)
public class ErrorOnWrongPasswordTests {
        private WebDriver driver;
        private final String name;
        private final String email;
        private final String password;
        private final Boolean isValidPassword;
    public ErrorOnWrongPasswordTests(String name, String email, String password, Boolean isValidPassword) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.isValidPassword = isValidPassword;

    }
    @Parameterized.Parameters
    public static Object[][] password() {
        return new Object[][] {
                {"hihi","hihi@mail.ru","sayhi", false},
                {"barney","haha@mail.ru"," ",false}
        };
    }
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
        objSignInPage.SignIn(name, email,password);

        var isValidPass = objSignInPage.IsValidPass();

        Assert.assertEquals(isValidPassword, isValidPass);


    }

    @After
    public void teardown() {
        driver.quit();
    }
}

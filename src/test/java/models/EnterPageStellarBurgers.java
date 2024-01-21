package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы входа
public class EnterPageStellarBurgers {

    private WebDriver driver;
    private By emailFieldEnter = By.xpath("//label[text()='Email']/parent::div/input");
    private By passwordFieldEnter = By.xpath("//label[text()='Пароль']/parent::div/input");

    public By logInButton = By.xpath(".//button[contains(@class, 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa') and text() = 'Войти']");
    public By signInLink = By.xpath(".//a[contains(@href, '/register')]");

    public EnterPageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    public void clickSignInLink() {
        driver.findElement(signInLink).click();

    }
    public void logInToAccount(String email, String password) {
        driver.findElement(emailFieldEnter).sendKeys(email);
        driver.findElement(passwordFieldEnter).sendKeys(password);
        driver.findElement(logInButton).click();

    }

}

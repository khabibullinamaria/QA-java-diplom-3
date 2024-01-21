package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы регистрации
public class SignInPageStellarBurgers {

    private WebDriver driver;
    private By nameField = By.xpath("//label[text()='Имя']/parent::div/input");
    private By emailField = By.xpath("//label[text()='Email']/parent::div/input");
    private By passwordField = By.xpath("//label[text()='Пароль']/parent::div/input");
    private By loginLink = By.xpath("//a[text()='Войти']");

    public By signInButton = By.xpath(".//button[contains(@class, 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa') and text()='Зарегистрироваться']");
    public By errorOnWrongPassword = By.xpath("//p[text()='Некорректный пароль']");


    public SignInPageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    public void SignIn(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();

    }

    public boolean IsValidPass() {
        var elements = driver.findElements(errorOnWrongPassword);
        if (elements.size() < 1) {
            return true;
        } else {
            return false;
        }
    }
}


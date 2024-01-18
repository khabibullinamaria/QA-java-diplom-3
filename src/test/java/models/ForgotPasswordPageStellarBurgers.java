package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы регистрации
public class ForgotPasswordPageStellarBurgers {

    private WebDriver driver;
    private By loginLink = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}


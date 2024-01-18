package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы регистрации
public class ProfilePageStellarBurgers {

    private WebDriver driver;
    public By profileTab = By.xpath("//a[text()='Профиль']");
    public By exitButton = By.xpath("//button[text()='Выход']");

    public ProfilePageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }
}


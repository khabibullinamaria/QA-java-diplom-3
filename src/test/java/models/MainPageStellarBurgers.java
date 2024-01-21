package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс главной страницы
public class MainPageStellarBurgers {

    private WebDriver driver;

    private By headerPersonalAccountButton= By.xpath(".//a[contains(@href, '/account')]");
    private By logInButtonMainPage = By.xpath(".//button[contains(@class,'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg') and text() = 'Войти в аккаунт']");
    public By createOrderButtonMainPage = By.xpath(".//button[contains(@class,'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg') and text() = 'Оформить заказ']");

    public By logo = By.xpath(".//a[contains(@href, '/')]");

    public By  constructorLink = By.xpath(".//p[text()='Конструктор']");

    public MainPageStellarBurgers (WebDriver driver){
        this.driver = driver;
    }

    public void clickHeaderPersonalAccountButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerPersonalAccountButton));
        driver.findElement(headerPersonalAccountButton).click();

    }

    public void clickLogInButtonMainPage() {
        driver.findElement(logInButtonMainPage).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }
}
package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы регистрации
public class ConstructorPageStellarBurgers {

    private WebDriver driver;
    public By constructorHeader = By.xpath("//h1[text()='Соберите бургер']");
    public By bunButton = By.xpath("//span[text()='Булки']");
    public By sauceButton = By.xpath("//span[text()='Соусы']");
    public By fillingButton = By.xpath("//span[text()='Начинки']");

    public By bunButtonParent = By.xpath("//span[text()='Булки']/parent::div");
    public By sauceButtonParent = By.xpath("//span[text()='Соусы']/parent::div");
    public By fillingButtonParent = By.xpath("//span[text()='Начинки']/parent::div");

    public ConstructorPageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    public void clickBunButton() {
        driver.findElement(bunButtonParent).click();
    }

    public void clickSauceButton() {
        driver.findElement(sauceButtonParent).click();
    }

    public void clickFillingButton() {
        driver.findElement(fillingButtonParent).click();
    }
}


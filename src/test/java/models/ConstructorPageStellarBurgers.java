package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы регистрации
public class ConstructorPageStellarBurgers {

    private WebDriver driver;
    public By constructorHeader = By.xpath("//h1[text()='Соберите бургер']");

    public By getButton(String name) {
        return By.xpath("//span[text()='" + name + "']");
    }

    public By getButtonParent(String name) {
        return By.xpath("//span[text()='" + name + "']/parent::div");
    }

    public ConstructorPageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    public void clickButton(String name) {
        driver.findElement(getButton(name)).click();
    }
}


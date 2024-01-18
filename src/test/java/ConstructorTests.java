import io.qameta.allure.Step;
import models.ConstructorPageStellarBurgers;
import models.EnterPageStellarBurgers;
import models.MainPageStellarBurgers;
import models.ProfilePageStellarBurgers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorTests {
    private WebDriver driver;

    @Test
    public void ChangeTabTestTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");

        String selectedClass = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

        ConstructorPageStellarBurgers constructorPage = new ConstructorPageStellarBurgers(driver);
        constructorPage.clickFillingButton();
        var fillingButtonParentClass = driver.findElement(constructorPage.fillingButtonParent).getAttribute("class");
        Assert.assertEquals(selectedClass, fillingButtonParentClass);

        constructorPage.clickSauceButton();
        var sauceButtonParentClass = driver.findElement(constructorPage.sauceButtonParent).getAttribute("class");
        Assert.assertEquals(selectedClass, sauceButtonParentClass);

        constructorPage.clickBunButton();
        var bunButtonParentClass = driver.findElement(constructorPage.bunButtonParent).getAttribute("class");
        Assert.assertEquals(selectedClass, bunButtonParentClass);
    }


    @After
    public void teardown() {
        driver.quit();
    }
}


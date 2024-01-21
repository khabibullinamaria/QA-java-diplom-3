import io.qameta.allure.Step;
import models.ConstructorPageStellarBurgers;
import models.EnterPageStellarBurgers;
import models.MainPageStellarBurgers;
import models.ProfilePageStellarBurgers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class ConstructorTests extends BaseTests {
    private final String tabName;

    public ConstructorTests(String tabName){
        this.tabName = tabName;
    }

    @Parameterized.Parameters
    public static Object[][] password() {
        return new Object[][] {
                { "Булки" },
                { "Соусы" },
                { "Начин" }
        };
    }

    @Test
    public void ChangeTabTestTest() {
        super.InitDriver("https://stellarburgers.nomoreparties.site/");

        String selectedClass = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

        ConstructorPageStellarBurgers constructorPage = new ConstructorPageStellarBurgers(driver);
        constructorPage.clickButton(tabName);
        var fillingButtonParentClass = driver.findElement(constructorPage.getButtonParent(tabName)).getAttribute("class");
        Assert.assertEquals(selectedClass, fillingButtonParentClass);
    }


    @After
    public void teardown() {
        driver.quit();
    }
}


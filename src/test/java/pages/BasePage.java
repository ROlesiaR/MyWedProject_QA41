package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected static WebDriver driver;
    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }
    public static boolean isElementPresent(WebElement element) {
        try {
            // Попытка выполнить любое действие с элементом
            element.isDisplayed();
            return true; // Элемент присутствует на странице
        } catch (NoSuchElementException | NullPointerException e) {
            return false; // Элемент не найден на странице
        }
    }

}

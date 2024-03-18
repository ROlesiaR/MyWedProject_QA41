package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.Set;


public class WindowAndTabTest {
    public static void main(String[] args) throws InterruptedException {
       // switchTab();
        sliderTest();

    }
    @Test
    public static void sliderTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/slider");
        driver.manage().window().maximize();

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider,30,0).build().perform();
        Thread.sleep(3000);

//        slider.sendKeys(Keys.ARROW_RIGHT);Thread.sleep(1000);
//        slider.sendKeys(Keys.ARROW_RIGHT);Thread.sleep(1000);
//        slider.sendKeys(Keys.ARROW_RIGHT);Thread.sleep(1000);
//        slider.sendKeys(Keys.ARROW_RIGHT);Thread.sleep(1000);
//        slider.sendKeys(Keys.ARROW_RIGHT);Thread.sleep(1000);
//        slider.sendKeys(Keys.ARROW_RIGHT);Thread.sleep(1000);
//        slider.sendKeys(Keys.ARROW_RIGHT);Thread.sleep(1000);
        driver.quit();


    }
    public static void switchTab(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        String mainWindowHandel = driver.getWindowHandle();
        WebElement newButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
        newButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindowHandels = driver.getWindowHandles();

        String newWindowHandel = "";
        for (String windowHandel: allWindowHandels){
            if(!windowHandel.equals(mainWindowHandel)){
                newWindowHandel = windowHandel;
                break;
            }
        }
        driver.switchTo().window(newWindowHandel);
        WebElement newPageElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        newPageElement.click();
        driver.quit();
    }
    @Test
    @Parameters("chrome")
    public static void dragAndDrop() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();

        WebElement elementToDrop = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement targetElement = driver.findElement(By.xpath("//div[@id='column-b']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(elementToDrop,targetElement).build().perform();
        Thread.sleep(5000);
        driver.quit();
    }
}

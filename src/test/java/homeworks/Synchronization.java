package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Synchronization {

    WebDriver driver;
    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void isEnabled () {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton= driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement enabledMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals("It's enabled!", enabledMessage.getText());
        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());

        enableButton.click();
        WebElement disabledMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals("It's disabled!", disabledMessage.getText());
        Assert.assertFalse(textBox.isEnabled());

    }
}
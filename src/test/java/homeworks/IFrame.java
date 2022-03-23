package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class IFrame {


    WebDriver driver;

    @Test
    public void iframeTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://html.com/tags/iframe/");

        Actions actions = new Actions(driver);

        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(5000);
        driver.switchTo().frame(0);

        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        Thread.sleep(5000);
        driver.switchTo().parentFrame();

        Thread.sleep(3000);

        driver.quit();

    }
}
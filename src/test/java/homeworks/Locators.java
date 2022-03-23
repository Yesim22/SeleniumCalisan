package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Locators {

    WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }

    @Test
    public void test(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals("PRODUCTS",driver.findElement(By.xpath("//span[@class='title']")).getText());

        List<WebElement> productList = new ArrayList<>();
        List<String> stringPriceList = new ArrayList<>();
        productList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        for(WebElement p : productList){
            stringPriceList.add(p.getText());
        }
        System.out.println(stringPriceList);

        List<Double> doublePriceList = new ArrayList<>();
        for(String w : stringPriceList){
            w = w.substring(1);
            Double x = Double.parseDouble(w);
            doublePriceList.add(x);
        }

        Collections.sort(doublePriceList);
        Assert.assertTrue("The minimum price is not greater than 5$..", doublePriceList.get(0) > 5 );
        Assert.assertTrue("The maxiumum price is not less than 50$..", doublePriceList.get(doublePriceList.size()-1) < 50 );
    }
}
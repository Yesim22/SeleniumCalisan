package homeworks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
public class SıgnInHomework {

    WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://automationpractice.com/index.php");

    }
    @Test
    public void signIn() throws InterruptedException {

        WebElement signInBtn = driver.findElement(By.xpath("//a[@class='login']"));
        signInBtn.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email_create']"));
        email.sendKeys("ysmylmz@gmail.com");

        WebElement createAccount = driver.findElement(By.xpath("//i[@class='icon-user left']"));
        createAccount.click();
        Assert.assertTrue(createAccount.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Yesim");
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Yilmaz");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Y.123");

        WebElement dayDropDown = driver.findElement(By.id("days"));
        Select selectDay = new Select(dayDropDown);
        WebElement monthDropDown = driver.findElement(By.id("months"));
        Select selectMonth = new Select(monthDropDown);
        WebElement yearDropDown = driver.findElement(By.id("years"));
        Select selectYear = new Select(yearDropDown);
        selectDay.selectByValue("16");
        selectMonth.selectByValue("2");
        selectYear.selectByValue("1994");
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Techproed");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("75531 Schaden Radial, Stammland, AL 81444-2920");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Virginia");

        WebElement stateDropDown = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select selectState = new Select(stateDropDown);
        selectState.selectByValue("46");

        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12345");
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("I want to do my homework :)");
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("+1 9345 6789");
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("+1 9345 6789");
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(" ");
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

        WebElement locateMyAccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(locateMyAccount.isDisplayed());

    }

    @After
    public void tearDown() {

        driver.close();
    }
}

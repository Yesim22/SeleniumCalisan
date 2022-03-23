package myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        //getting the page source
        String pageSource = driver.getPageSource();

        //Checking if 'Registry' exist on the entire page
        if (pageSource.contains("Registry")){
            System.out.println("PASS");
        }else{
            System.out.println("FAILS");
        }

        driver.quit();
    }
}

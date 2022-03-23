package myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_Navigations {

    public static void main(String[] args) throws InterruptedException {

        //Step 1: set the path and driver name
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        //Step 2: create WebDriver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

        //Step 3: now I have driver, I can use driver in automation
        //go to google
        driver.get("https://www.google.com");
        //putting 5 second wait
        Thread.sleep(5000);//5 seconds hard wait

//        On the same class, Navigate to amazon home page https://www.amazon.com/
//        navigate() is also used to go to the webpages
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(5000);

//        Navigate back to google
        driver.navigate().back();
        Thread.sleep(5000);

//        Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep(5000);
//        Refresh the page
        driver.navigate().refresh();
        Thread.sleep(5000);
//        Close/Quit the browser
//        To close a driver, we can use close() or quit()
        driver.close();
//        driver.quit();

    }
    /*
     * What is the difference  between get() and navigate.to ?
     * 1. get() easier to use, used more than navigate()
     * 2. get() a little faster
     * 3. get() takes only string, but navigate.to takes string or URL as parameter
     * 4. navigate has more options: back, forward, refresh
     * ----------------------------------------------------------------
     *What is the difference between close and quit?
     *close() -> closes only current working browser
     *quit() -> closes all browsers.
     *-------------------------------------------------------
     *What is Thread.sleep()?
     *It is used to put some wait.
     *Thread.sleep(5000); puts 5 second ON THIS STEP
     *Thread.sleep is a JAVA wait. It is not a selenium wait.
     *Because this is HARD wait.
     *It means, this will put extra wait EVEN IF WE DON'T NEED
     *We will use selenium waits. They will be DYNAMIC WAIT.
     * --------------------------
     * */
}

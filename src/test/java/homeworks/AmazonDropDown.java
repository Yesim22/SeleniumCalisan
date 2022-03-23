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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonDropDown {
    WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.amazon.com");

    }
    @Test
    public void signIn() throws InterruptedException {

        //Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //Print the first selected option and assert if it equals “All Departments”
        Select select = new Select(dropDown);
        WebElement firstOption = select.getFirstSelectedOption();
        Thread.sleep(5000);
        String textOfFirstOption = firstOption.getText();
        Assert.assertEquals("All Departments", textOfFirstOption);

        //Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you
        //select you to need to use the get first selected option method)
        WebElement fourthOption = select.getOptions().get(3);
        String nameFourthOption = fourthOption.getText();
        System.out.println("Fourt Option => " + nameFourthOption);
        Assert.assertFalse(nameFourthOption.equals("Amazon Devices"));
        //fourth option is "Baby", not "Amazon Devices"

        //Print all of the dropdown options
        List<WebElement> allDropdowns = select.getOptions();
        for (WebElement eachDropdown : allDropdowns) {
            System.out.print(eachDropdown.getText() + " - ");
        }
        System.out.println();

        //Print the total number of options in the dropdown
        int numberOfDropdowns = allDropdowns.size();
        System.out.println("Total Number Of Options => " + numberOfDropdowns);

        //Check if Appliances is a drop-down option. Print true if “Appliances” is an option. Print false
        //otherwise.

        boolean isContain = false;

        for (WebElement eachDropdown : allDropdowns) {
            if (eachDropdown.getText().equals("Appliances")) {
                isContain = true;
            }
        }

        System.out.println(isContain);

        //BONUS: Check if the dropdown is in Alphabetical Order
        List<String> dropdownString = new ArrayList<>();
        List<String> dropdownStringOrdered = new ArrayList<>();
        for (WebElement eachDropdown : allDropdowns) {
            dropdownString.add(eachDropdown.getText().toUpperCase());
            dropdownStringOrdered.add(eachDropdown.getText().toUpperCase());
        }
        System.out.println(dropdownString);
        Collections.sort(dropdownStringOrdered);
        System.out.println(dropdownStringOrdered);
        if (dropdownString.equals(dropdownStringOrdered)) {
            System.out.println("Dropdown is in Alphabetical Order...");
        } else {
            System.out.println("Dropdown is not in Alphabetical Order...");
        }

    }
    @After
    public void tearDown () {
        driver.close();

    }
}
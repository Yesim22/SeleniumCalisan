package homeworks;

import com.google.common.collect.Ordering;
import myfirstproject.utilities.TestBase;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
public class firstColumnLastName extends TestBase {

    @Test
    public void firstColumn() {

        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("*****First Column Data,Last Name*****");
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[1]"));
        List<String> lastNameList = new ArrayList<>();
        for(WebElement eachLastNames : lastNames){
            lastNameList.add(eachLastNames.getText());
        }
        System.out.println(lastNameList);
        boolean isOrdered =Ordering.natural().isOrdered(lastNameList);
        Assert.assertFalse(isOrdered);

    }
}

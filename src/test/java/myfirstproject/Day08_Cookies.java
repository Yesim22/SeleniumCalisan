package myfirstproject;


import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import java.util.Set;

public class Day08_Cookies extends TestBase {
    @Test
    public void handleCookies(){
//-Go to amazon  and automate the tasks:
        driver.get("https://www.amazon.com");
//1. Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numberOfCookies = allCookies.size();//7
        System.out.println(numberOfCookies);
//2. Print all the cookies
        for (Cookie eachCookie : allCookies){
            System.out.println("Each Cookie : "+eachCookie);
            System.out.println("Each Cookie Name : "+eachCookie.getName());
            System.out.println("Each Cookie Value : "+eachCookie.getValue());
        }
//3. Get the cookies by their name
//        When we want to get single cookie, we can get by cookie name
        System.out.println("Cookie name i18n-prefs : "+driver.manage().getCookieNamed("i18n-prefs"));
//4. Add new cookie
//        1. Create Cookies object
        Cookie cookie = new Cookie("My-Fav-Cookie","White-Chocolate");
//        2. add cookie
        driver.manage().addCookie(cookie);
//        Check if cookie is added
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies.size());//8
//5.  Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");//deleting the last cookie
//    check if cookie is deleted
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies.size());//8
//6. Delete all of the cookies
        driver.manage().deleteAllCookies();
        //    check if All cookies are deleted
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies.size());//0
    }
}
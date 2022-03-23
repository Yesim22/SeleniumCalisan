package myfirstproject;

import org.junit.*;

public class Day02_FirstJUnitClass {

     /*
        JUNIT is a testing framework
        JUNIT is one of the oldest JAVA testing framework
        Developers also use JUNIT for their UNIT TESTING
        Testers also use UNIT TESTING for creating Automation Test framework
        No more main method
        JUNIT has 7 major annotation
        1. @Test annotation is used to create test class
        Note: All test() method will be void
        Because test() methods are used for assertions
        2. @Before : Runs before each @Test annotation
        3. @After : Runs after each @Test annotation
        4. @BeforeClass : Runs only one before each class
        5. @AfterClass : Runs only once after each class
        6. @Ignore : To skip a Test case

    **************JUNIT ASSERTION
    We use JUnit assertion if actual and expected is equal
    Instead of using if-else statement, we will use JUnit assertions
    It will come from Assert class
    1. Assert.assertEquals("ACTUAL","EXPECTED");
    2. Assert.assertTrue("ACTUAL".contains("EXPECTED"));
    3. Assert.assertFalse("ACTUAL".contains("EXPECTED"));

    */

    @Before
    public void setUp(){
        System.out.println("This is Before Method");
    }

    @Test
    public void test01(){
        System.out.println("This is Test1");
    }

    @Test
    public void test02(){
        System.out.println("This is Test2");
    }

    @Ignore
    @Test
    public void test03(){
        System.out.println("This is Test3");
    }

    @Test
    public void test04(){
        System.out.println("This is Test4");
    }

    @After
    public void tearDown(){
        System.out.println("This is Tear Down Method");
    }

    //ASSERTION
    //if expected
    @Test
    public void assertions(){

        //1.Assert.assertEquals("expected","actual");
        //If assertion fails, then we see error message on the console
        //If assertion passes then we see green checkmark only
        Assert.assertEquals("java", "java");

        //2.Assert.assertTrue(BOOLEAN);
        Assert.assertTrue("Selenium".contains("e"));

        //3.Assert.assertFalse(BOOLEAN);
        Assert.assertFalse("Selenium".contains("java"));// "Selenium".contains("a") -> FALSE

        //We can add a message as well.
        //This message will ONLY DISPLAY WHEN ASSERTION FAILS!!!!
        Assert.assertEquals("ASSERTION FAILED!","java","java");


    }
}

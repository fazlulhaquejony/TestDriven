package com.fjtechsolutions.testdriven;

import com.fjtechsolutions.testdriven.controller.TestController;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestDrivenTest {

    @DisplayName("Equals_and_Not_Equals")
    @Test
    public void checkDataEqualsOrNotEquals()
    {
       // System.out.println("Running Test:checkDataEqualsOrNotEquals");
        TestController testController = new TestController();
        int c = testController.add(2,3);
        assertEquals(5,c,"Must be equal 5");
        assertNotEquals(6,c,"must be equal 6");
    }

    @DisplayName("Null or Not NUll")
    @Test
    @Order(1)
    public void testNullAndNotNull()
    {
        //System.out.println("Running Test:testNullAndNotNull");
        TestController testController = new TestController();
        String str1 = null;
        String str2 = "CheckNot Null";

        assertNull(testController.checkNull(str1),"must be null");
        assertNotNull(testController.checkNull(str2),"must not be null");

    }


    @DisplayName("same and not same")
    @Test
    public void testSameAndNotSame()
    {
        TestController testController = new TestController();
        String str = "not Same Check";
        assertSame(testController.getSameNotSameValue(),testController.getSameNotSameValueDuplicate(),"the objects should be equals");
        assertNotSame(testController.getSameNotSameValue(),str,"value should not same");
    }

    @DisplayName("True or False")
    @Test
    public void testTrueOrFalse()
    {
        TestController testController = new TestController();
        int greater = 10;
        int smaller = 5;

        assertTrue(testController.getTrueOrFalse(greater,smaller),"Must be true");
        assertFalse(testController.getTrueOrFalse(smaller,greater), "Must be false");
    }

    @DisplayName("Array Equal Check")
    @Test
    public void testArrayEquals()
    {
        TestController testController = new TestController();
        String[] arrayString = {"A","B","C"};
        assertArrayEquals(arrayString,testController.getArrayString(),"must be equals");
    }


    @DisplayName("List check Data")
    @Test
    public void testIteratorEqual()
    {
        TestController testController = new TestController();
        List<String> targetList = List.of("matcher","20","data");
        assertLinesMatch(testController.getStringList(),targetList,"must match");
        assertIterableEquals(testController.getStringList(),targetList,"must match");
    }


    @DisplayName("Test throws or not throws exception")
    @Test
    public void testThrowsOrNotThrowsException()
    {
        TestController testController = new TestController();
        assertThrows(Exception.class,()->{testController.throwException(-1);},"should Throw Exception");
        assertDoesNotThrow(()->{testController.throwException(1);},"should not Throw Exception");
    }

    @DisplayName("TimeOut")
    @Test
    public void testTimeOut()
    {
        TestController testController = new TestController();
        assertTimeoutPreemptively(Duration.ofSeconds(3),()->{testController.checkTimeOut();},"method should execute in 3 seconds");
    }


}
// TestController testController;

   /* @BeforeEach
    public  void setUpBeforeEach()
    {
        testController = new TestController();
        System.out.println("@BeforeEach is executed in each test methods ");
    }

    @AfterEach
    public void tearDownAfterEach()
    {
        System.out.println("After each is working");
    }

    @BeforeAll
    static void sutUpForBeforeAllMethods()
    {
        System.out.println("@BeforeAll will execute one time at starting");
    }

    @AfterAll
    static  void setUpAfterAllMethods()
    {
        System.out.println("@AfterAll will execute one time at the End");

    }*/
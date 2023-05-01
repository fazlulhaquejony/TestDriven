package com.fjtechsolutions.testdriven.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

    //divided by 3 equal to Fizz
    // divided by 5 equal to Buzz
    // divided by 3 and 5  equal to FizzBuzz
    //or print the digit
   // @Test
    @DisplayName("FizzBuzz Compute Test2")
    @ParameterizedTest(name="value={0},expected={1}")
    @CsvFileSource(resources = "/FiztestCsv.csv")
    public void fizBuzzComputeTest(int value, String expected)
    {
         FizzBuzz fizzBuzz = new FizzBuzz();
        // fizzBuzz.fizBuzzCompute(int computer);
  /*       assertEquals("Fizz",fizzBuzz.fizBuzzCompute(3),"Should print  Fizz");
         assertEquals("Buzz",fizzBuzz.fizBuzzCompute(5),"Should print  Buzz");
         assertEquals("FizzBuzz",fizzBuzz.fizBuzzCompute(15),"Should print  FizzBuzz");
        assertEquals("2",fizzBuzz.fizBuzzCompute(2),"Should print  FizzBuzz");
    */
        assertEquals(expected,fizzBuzz.fizBuzzCompute(value));

    }
}

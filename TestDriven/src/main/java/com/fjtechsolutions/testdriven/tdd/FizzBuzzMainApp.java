package com.fjtechsolutions.testdriven.tdd;

public class FizzBuzzMainApp {

    public static void main(String[] args)
    {

        FizzBuzz fizzBuzz = new FizzBuzz();
        for(int i =0; i<=100;i++)
        {
            System.out.println(i+","+ fizzBuzz.fizBuzzCompute(i));
        }
    }

}

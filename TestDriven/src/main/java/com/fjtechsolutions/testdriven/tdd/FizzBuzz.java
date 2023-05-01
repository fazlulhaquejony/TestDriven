package com.fjtechsolutions.testdriven.tdd;

public class FizzBuzz {
    public String fizBuzzCompute(int i) {

        StringBuilder stringBuilder = new StringBuilder();
        if(i%3==0&&i%5==0)
        {
            return stringBuilder.append("FizzBuzz").toString();
        }
        else if(i%3==0)
        {
            return stringBuilder.append("Fizz").toString();
        }
        else if(i%5==0)
        {
            return stringBuilder.append("Buzz").toString();
        }
        else
        {
          return i+"";
        }

    }
}

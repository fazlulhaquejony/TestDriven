package com.fjtechsolutions.testdriven.controller;

import java.util.List;

public class TestController {

    private String sameNotSameValue ="String is same";
    private String sameNotSameValueDuplicate =sameNotSameValue;
    private String[] arrayString = {"A","B","C"};
    private List<String> stringList = List.of("matcher","20","data");
    public int add(int a, int b)
    {
        return a+b;
    }

    public Object checkNull(Object obj)
    {
        if(obj != null)
        {
            return obj;
        }
        return null;
    }

    public String getSameNotSameValue()
    {
        return sameNotSameValue;
    }

    public String getSameNotSameValueDuplicate()
    {
        return sameNotSameValueDuplicate;
    }

    public boolean getTrueOrFalse(int a, int b)
    {
        if(a>b)
        {
            return  true;
        }
        return false;
    }

    public String[] getArrayString()
    {
        return arrayString;
    }

    public List<String> getStringList()
    {
        return stringList;
    }

    public String throwException(int a) throws Exception
    {
        if(a<0)
        {
            throw new Exception("a can ton be less than Zero");

        }
        return "a value is : " + a;
    }

    public void checkTimeOut() throws InterruptedException
    {
        System.out.println("I am going to sleep");
        Thread.sleep(2000);
        System.out.println("I have woke up");
    }
}

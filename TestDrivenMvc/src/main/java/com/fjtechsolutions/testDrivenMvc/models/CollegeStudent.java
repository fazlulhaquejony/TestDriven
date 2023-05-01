package com.fjtechsolutions.testDrivenMvc.models;


import lombok.Data;

@Data
public class CollegeStudent implements Student {


    private int id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private StudentGrades studentGrades;


    @Override
    public String studentInformation() {
        return getFullName() + " " + getEmailAddress();
    }

    @Override
    public String getFullName() {
        return getFirstname() + " " + getLastname();
    }


    private String getFirstNameAndId(){

        return getFirstname()+" "+getId();
    }



}

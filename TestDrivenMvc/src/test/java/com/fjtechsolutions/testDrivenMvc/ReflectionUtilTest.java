package com.fjtechsolutions.testDrivenMvc;

import com.fjtechsolutions.testDrivenMvc.models.CollegeStudent;
import com.fjtechsolutions.testDrivenMvc.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TestDrivenMvcApplication.class)
public class ReflectionUtilTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent collegeStudent;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    public  void studentBeforeEach()
    {
        collegeStudent.setFirstname("Naim");
        collegeStudent.setLastname("Afzal");
        collegeStudent.setEmailAddress("naim@fjtechsolutions.com");
        collegeStudent.setStudentGrades(studentGrades);

        ReflectionTestUtils.setField(collegeStudent,"id",1);
        ReflectionTestUtils.setField(collegeStudent,"studentGrades",
                new StudentGrades(new ArrayList<>(Arrays.asList(100.0,85.0,76.50,91.75))));
    }


    @Test
    public void getPrivateField()
    {
        assertEquals(1,ReflectionTestUtils.getField(collegeStudent,"id"));
    }

    @Test
    public void invokePrivateMethod()
    {
       assertEquals("Naim 1",ReflectionTestUtils.invokeMethod(collegeStudent,"getFirstNameAndId"),"Fail!! private method is not called");
    }


}

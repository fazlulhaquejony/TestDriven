package com.fjtechsolutions.testDrivenMvc;

import com.fjtechsolutions.testDrivenMvc.dao.ApplicationDao;
import com.fjtechsolutions.testDrivenMvc.models.CollegeStudent;
import com.fjtechsolutions.testDrivenMvc.models.StudentGrades;
import com.fjtechsolutions.testDrivenMvc.services.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes=TestDrivenMvcApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent collegeStudent;

    @Autowired
    StudentGrades studentGrades;

   // @Mock
    @MockBean
    private ApplicationDao applicationDao;

    //@InjectMocks
    @Autowired
    private ApplicationService applicationService;


    @BeforeEach
    public void beforeEach()
    {
        collegeStudent.setFirstname("Ahsan");
        collegeStudent.setLastname("Habib");
        collegeStudent.setEmailAddress("ahsanhabib@gmail.com");
        collegeStudent.setStudentGrades(studentGrades);
    }

    @DisplayName("When and verify")
    @Test
    public void asserEqualsTestAddGrades()
    {
        when(applicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults())).thenReturn(100.0);

        assertEquals(100,applicationService.addGradeResultsForSingleClass(studentGrades.getMathGradeResults()));

        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        verify(applicationDao,times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

    }


    @DisplayName("Find gpa")
    @Test
    public void assertEqualsFindGpa()
    {
        when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults())).thenReturn(88.31);

        assertEquals(88.31,applicationDao.findGradePointAverage(collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Not Null")
    @Test
    public void testAssertNotNull()
    {
        when(applicationDao.checkNull(studentGrades.getMathGradeResults())).thenReturn(true);

        assertNotNull(applicationService.checkNull(collegeStudent.getStudentGrades().getMathGradeResults()),"object should not be null");
    }

    @DisplayName("Throw runTime eroor")
    @Test
    public void throwRuntimeError()
    {
        CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");

        doThrow(new RuntimeException()).when(applicationDao).checkNull(nullStudent);

        assertThrows(RuntimeException.class,() ->{
            applicationService.checkNull(nullStudent);
        });

        verify(applicationDao,times(1)).checkNull(nullStudent);

    }


    @DisplayName("Multiple Stubbing")
    @Test
    public void stubbingConsecutiveCalls()
    {
        CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");

        when(applicationDao.checkNull(nullStudent))
                .thenThrow(new RuntimeException())
                .thenReturn("do not return exception second time");
        //first time call
        assertThrows(RuntimeException.class,()->{
             applicationService.checkNull(nullStudent);
            });
        //second time call
        assertEquals("do not return exception second time",
                applicationService.checkNull(nullStudent));

        verify(applicationDao,times(2)).checkNull(nullStudent);
    }
}

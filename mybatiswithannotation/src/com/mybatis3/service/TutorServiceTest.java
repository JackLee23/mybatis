package com.mybatis3.service;

import com.mybatis3.domain.Tutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TutorServiceTest {
    public static TutorService tutorService;

    @Before
    public void setup() {
        tutorService = new TutorService();
    }

    @After
    public void teardown() {
        tutorService = null;
    }

    @Test
    public void testFindTutorById() {
        Tutor tutor = tutorService.findTutorById(2);
        System.out.println("tutor = " + tutor);
    }

    @Test
    public void testFindTutorByIdWithDynamic() {
        Tutor tutor = tutorService.findTutorByIdWithDynamic(2);
        System.out.println("tutor = " + tutor);
    }

    @Test
    public void testFindTutorByNameAndEmail() {
        Tutor tutor = tutorService.findTutorByNameAndEmail("john", "john@gmail.com");
        System.out.println("tutor = " + tutor);
    }

    @Test
    public void testInsertTutor() {
        int count = tutorService.insertTutor();
        System.out.println("影响了" + count + "行");
    }

    @Test
    public void testUpdateTutor() {
        int count = tutorService.updateTutor();
        System.out.println("影响了" + count + "行");
    }

    @Test
    public void testDeleteTutorById() {
        int count = tutorService.deleteTutor(4);
        System.out.println("影响了" + count + "行");
    }
}

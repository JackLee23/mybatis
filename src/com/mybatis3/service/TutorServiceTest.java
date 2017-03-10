package com.mybatis3.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/2/28.
 */
public class TutorServiceTest {
    private static TutorService tutorService;

    @Before
    public  void setUp() {
        tutorService = new TutorService();
    }

    @After
    public  void tearDown() {
        tutorService = null;
    }

    @Test
    public void testFindTutorById() {
        tutorService.findTutorById(2);
    }
}

package com.mybatis3.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseServiceTest {
    private static CourseService courseService;
    @Before
    public void setup() {
        courseService = new CourseService();
    }

    @After
    public void teardown() {
        courseService = null;
    }

    @Test
    public void testSearchCourses() {
        courseService.searchCourses();
    }

    @Test
    public void testSearchCoursesUseChoose() {
        courseService.searchCoursesUseChoose();
    }

    @Test
    public void testSearchCoursesUseWhere() {
        courseService.searchCoursesUseWhere();
    }

    @Test
    public void testSearchCoursesByTutor() {
        courseService.searchCoursesByTutor();
    }

    @Test
    public void testSearchCoursesByTutorUseIn() {
        courseService.searchCoursesByTutorUseIn();
    }
}

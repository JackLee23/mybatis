package com.mybatis3.service;

import com.mybatis3.domain.Course;
import com.mybatis3.mappers.CourseMapper;
import com.mybatis3.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class CourseService {
    void searchCourses() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("tutorId", 1);
            map.put("courseName", "%java%");
            map.put("startDate", new Date(1488124800000L));
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            sqlSession.commit();
            List<Course> courses = mapper.searchCourses(map);
            for (Course course : courses) {
                System.out.println(course);
            }
        }
        finally {
            sqlSession.close();
        }
    }

    void searchCoursesUseChoose() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("searchBy", "CourseName");
            map.put("courseName", "%java%");
            map.put("startDate", new Date(1488124800000L));
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            List<Course> courses = mapper.searchCoursesUseChoose(map);
            sqlSession.commit();
            for (Course course : courses) {
                System.out.println(course);
            }
        }
        finally {
            sqlSession.close();
        }
    }

    void searchCoursesUseWhere() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("courseName", "%java%");
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            List<Course> courses = mapper.searchCoursesUseWhere(map);
            sqlSession.commit();
            for (Course course : courses) {
                System.out.println(course);
            }
        }
        finally {
            sqlSession.close();
        }
    }

    void searchCoursesByTutor() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Integer> tutorIds = new ArrayList<Integer>();
            tutorIds.add(1);
            tutorIds.add(3);
            tutorIds.add(6);
            map.put("tutorIds", tutorIds);
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            List<Course> courses = mapper.searchCoursesByTutors(map);
            sqlSession.commit();
            for (Course course : courses) {
                System.out.println(course.getName()+", "+course.getDescription());
            }
        }
        finally {
            sqlSession.close();
        }
    }

    void searchCoursesByTutorUseIn() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Integer> tutorIds = new ArrayList<Integer>();
            tutorIds.add(1);
            tutorIds.add(3);
            tutorIds.add(6);
            map.put("tutorIds", tutorIds);
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            List<Course> courses = mapper.searchCoursesByTutorsUseIn(map);
            sqlSession.commit();
            for (Course course : courses) {
                System.out.println(course.getName()+", "+course.getDescription());
            }
        }
        finally {
            sqlSession.close();
        }
    }
}

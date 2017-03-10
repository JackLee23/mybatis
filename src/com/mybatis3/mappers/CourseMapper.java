package com.mybatis3.mappers;

import com.mybatis3.domain.Course;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    List<Course> searchCourses(Map<String, Object> map);
    List<Course> searchCoursesUseChoose(Map<String, Object> map);
    List<Course> searchCoursesUseWhere(Map<String, Object> map);
    List<Course> searchCoursesByTutors(Map<String, Object> map);
    List<Course> searchCoursesByTutorsUseIn(Map<String, Object> map);
}

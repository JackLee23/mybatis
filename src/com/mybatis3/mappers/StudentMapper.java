package com.mybatis3.mappers;

import com.mybatis3.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
    Student findStudentById();
    void insertStudent(Student student);
    Student selectStudentWithAddress(int studId);
    void updateStudent(Student student);
    List<Student> findAllStudentsByNameEmail(String name, String email);
    Map<Integer, Student> findAllStudentsWithMap();
    //List<Student> findAllStudentsWithRowBounds();
}

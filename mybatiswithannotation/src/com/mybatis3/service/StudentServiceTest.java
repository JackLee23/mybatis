package com.mybatis3.service;

import com.mybatis3.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentServiceTest {
    public static StudentService studentService;

    @Before
    public void setup() {
        studentService = new StudentService();
    }

    @After
    public void teardown() {
        studentService = null;
    }

    @Test
    public void testFindStudent() {
        int count = studentService.insertStudent(9);
        System.out.println("影响了" + count + "行");
    }

    @Test
    public void testUpdateStudent() {
        int count = studentService.updateStudent(9);
        System.out.println("影响了" + count + "行");
    }

    @Test
    public void testDeleteStudent() {
        int count = studentService.deleteStudent();
        System.out.println("影响了" + count + "行");
    }

    @Test
    public void testFindStudentById() {
        Student stud = studentService.findStudentById(9);
        System.out.println(stud);
    }

    @Test
    public void testFindAllStudents() {
        List<Student> list = studentService.findAllStudents();
        System.out.println(list);
    }

    @Test
    public void testFindAllStudentsWithResultMap() {
        List<Student> list = studentService.findAllStudentsWithResultMap();
        System.out.println(list);
    }

    @Test
    public void testFindStudentByIdWithResultMap() {
        Student student = studentService.findStudentByIdWithResultMap(1);
        System.out.println(student);
    }

    @Test
    public void testSelectStudentWithAddress() {
        Student student = studentService.selectStudentWithAddress(1);
        System.out.println("student = " + student);
        System.out.println("Address = " + student.getAddress());
    }
}

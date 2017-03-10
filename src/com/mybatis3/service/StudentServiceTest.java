package com.mybatis3.service;

import com.mybatis3.domain.Address;
import com.mybatis3.domain.Gender;
import com.mybatis3.domain.PhoneNumber;
import com.mybatis3.domain.Student;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentServiceTest {

  private static StudentService studentService;

  @BeforeClass
  public static void setup() {
    studentService = new StudentService();
  }

  @AfterClass
  public static void teardown() {
    studentService = null;
  }

  @Test
  public void testFindAllStudents() {
    List<Student> students = studentService.findAllStudents();
    for(Student student : students) {
      System.out.println(student);
    }
  }

  @Test
  public void testFindStudentById() {
    Student student = studentService.findStudentById(1);
    Assert.assertNotNull(student);
    System.out.println(student);
  }

  @Test
  public void testFindStudentById1() {
    studentService.findStudentById();
  }

  @Test
  public void testCreateStudent() {
    Student student = new Student();
    int id = 3;
    student.setStudId(id);
    student.setName("student_" + id);
    student.setEmail("student_" + id + "@gmail.com");
    //student.setDob(new Date());
    studentService.createStudent(student);
    Student newStudent = studentService.findStudentById(id);
    Assert.assertNotNull(newStudent);
  }

  @Test
  public void testUpdateStudent() {
    studentService.updateStudent(2);
  }

  @Test
  public void testInsertStudent() {
    Student student = new Student();
    student.setName("Mary");
    student.setEmail("mary@gmail.com");
    student.setPhone(new PhoneNumber("789-951-7536"));
    student.setAddress(new Address(1, "Naperville", "CHICAGO", "IL", "60515", "USA"));
    student.setGender(Gender.FEMALE);
    studentService.createStudent(student);
  }

  @Test
  public void testFindAllStudentsByNameEmail() {
    studentService.findAllStudentsByNameEmail("Jack", "jack@gmail.com");
  }

  @Test
  public void testFindAllStudentsWithMap() {
    Map<Integer, Student> map = studentService.findAllStudentsWithMap();
    System.out.println(map);
  }

  @Test
  public void testGetStudentIdNameMap() {
    Map<Integer, String> map = studentService.getStudentIdNameMap();
    System.out.println(map);
  }
}

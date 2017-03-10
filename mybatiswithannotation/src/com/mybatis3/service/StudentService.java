package com.mybatis3.service;

import com.mybatis3.domain.Address;
import com.mybatis3.domain.PhoneNumber;
import com.mybatis3.domain.Student;
import com.mybatis3.mappers.StudentMapper;
import com.mybatis3.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentService {
  private Logger logger = LoggerFactory.getLogger(getClass());
  
  int insertStudent(int studId) {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      Student stud = new Student();
      //stud.setStudId(studId);
      stud.setName("Jerry");
      stud.setEmail("jerry@gmail.com");
      stud.setAddress(new Address(1));
      stud.setPhone(new PhoneNumber("548-478-15769"));
      int count = studentMapper.insertStudent(stud);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }

  int updateStudent(int studId) {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      Student stud = new Student();
      stud.setStudId(studId);
      stud.setName("XXX");
      stud.setEmail("xxx@gmail.com");
      stud.setPhone(new PhoneNumber("741-963-15769"));
      int count = studentMapper.updateStudent(stud);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }

  int deleteStudent() {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      int count = studentMapper.deleteStudent(10);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }

  Student findStudentById(Integer studId) {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      Student stud = studentMapper.findStudentById(studId);
      sqlSession.commit();
      return stud;
    } finally {
      sqlSession.close();
    }
  }

  List<Student> findAllStudents() {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      List<Student> students = studentMapper.findAllStudents();
      sqlSession.commit();
      return students;
    } finally {
      sqlSession.close();
    }
  }

  List<Student> findAllStudentsWithResultMap() {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      List<Student> students = studentMapper.findAllStudentsWithResultMap();
      sqlSession.commit();
      return students;
    } finally {
      sqlSession.close();
    }
  }

  Student findStudentByIdWithResultMap(int studId) {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      Student student = studentMapper.findStudentByIdWithResultMap(studId);
      sqlSession.commit();
      return student;
    } finally {
      sqlSession.close();
    }
  }

  Student selectStudentWithAddress(int studId) {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      Student student = studentMapper.selectStudentWithAddress(studId);
      sqlSession.commit();
      return student;
    } finally {
      sqlSession.close();
    }
  }
}

package com.mybatis3.service;

import com.mybatis3.domain.Student;
import com.mybatis3.mappers.StudentMapper;
import com.mybatis3.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
  private Logger logger = LoggerFactory.getLogger(getClass());
  
  public List<Student> findAllStudents() {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      return studentMapper.findAllStudents();
    } finally {
      sqlSession.close();
    }
  }
  
  public Student findStudentById(Integer studId) {
    logger.debug("Select Student By ID :{}", studId);
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      //Student student = (Student)sqlSession. selectOne("com.mybatis3.mappers.StudentMapper.findStudentById", studId);
      return studentMapper.findStudentById(studId);
    } finally {
      sqlSession.close();
    }
  }

  public void findStudentById() {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
    Student student = studentMapper.selectStudentWithAddress(1);
    System.out.println("Student :" + student);
    System.out.println("Address :" + student.getAddress());
  }

  public void createStudent(Student student) {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      studentMapper.insertStudent(student);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  void updateStudent(int studId) {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      Student student = new Student();
      student.setStudId(studId);
      student.setName("Jack");
      student.setEmail("jack@gmail.com");
      studentMapper.updateStudent(student);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }

  void findAllStudentsByNameEmail(String name, String email) {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      List<Student> students = studentMapper.findAllStudentsByNameEmail(name, email);
      for (Student student : students) {
        System.out.println(student);
      }
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }

  Map<Integer, Student> findAllStudentsWithMap() {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      Map<Integer, Student> studentMap = sqlSession.selectMap("com.mybatis3.mappers.StudentMapper.findAllStudentsWithMap", "studId");
      sqlSession.commit();
      return studentMap;
    } finally {
      sqlSession.close();
    }
  }

/*  void findAllStudentsWithRowBounds() {
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      int offset =0 , limit =25;
      RowBounds rowBounds = new RowBounds(offset, limit);
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      List<Student> students = studentMapper.findAllStudentsWithRowBounds();
      for(Student student : students) {
        System.out.println(student);
      }
    } finally {
      sqlSession.close();
    }
  }*/

  public Map<Integer, String> getStudentIdNameMap() {
    final Map<Integer, String> map = new HashMap<Integer, String>();
    SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    try {
      sqlSession.select("com.mybatis3.mappers.StudentMapper.findAllStudents",
              new ResultHandler() {
                @Override
                public void handleResult(ResultContext context) {
                  Student student = (Student) context.getResultObject();
                  map.put(student.getStudId(), student.getName());
                }
      } );
    } finally {
      sqlSession.close();
    }
    return map;
  }
}

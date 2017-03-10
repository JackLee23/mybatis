package com.mybatis3.service;

import com.mybatis3.domain.Tutor;
import com.mybatis3.mappers.TutorMapper;
import com.mybatis3.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

public class TutorService {
    Tutor findTutorById(int tutorId) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            TutorMapper tutorMapper = sqlSession.getMapper(TutorMapper.class);
            Tutor tutor = tutorMapper.findTutorById(tutorId);
            sqlSession.commit();
            return tutor;
        } finally {
            sqlSession.close();
        }
    }

    Tutor findTutorByIdWithDynamic(int tutorId) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            TutorMapper tutorMapper = sqlSession.getMapper(TutorMapper.class);
            Tutor tutor = tutorMapper.findTutorByIdWithDynamic(tutorId);
            sqlSession.commit();
            return tutor;
        } finally {
            sqlSession.close();
        }
    }

    Tutor findTutorByNameAndEmail(String name, String email) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            TutorMapper tutorMapper = sqlSession.getMapper(TutorMapper.class);
            Tutor tutor = tutorMapper.findTutorByNameAndEmail(name, email);
            sqlSession.commit();
            return tutor;
        } finally {
            sqlSession.close();
        }
    }

    int insertTutor() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            TutorMapper tutorMapper = sqlSession.getMapper(TutorMapper.class);
            Tutor tutor = new Tutor();
            tutor.setName("Jack");
            tutor.setEmail("jack@gmail.com");
            int count = tutorMapper.insertTutor(tutor);
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }

    int updateTutor() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            TutorMapper tutorMapper = sqlSession.getMapper(TutorMapper.class);
            Tutor tutor = new Tutor();
            tutor.setTutorId(3);
            tutor.setName("Sara");
            tutor.setEmail("jack@gmail.com");
            int count = tutorMapper.updateTutor(tutor);
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }

    int deleteTutor(int tutorId) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            TutorMapper tutorMapper = sqlSession.getMapper(TutorMapper.class);
            int count = tutorMapper.deleteTutor(tutorId);
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }
}

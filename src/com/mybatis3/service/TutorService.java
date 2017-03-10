package com.mybatis3.service;

import com.mybatis3.domain.Course;
import com.mybatis3.domain.Tutor;
import com.mybatis3.mappers.TutorMapper;
import com.mybatis3.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
public class TutorService {

    public void findTutorById(int tutorId) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);
            Tutor tutor = mapper.findTutorById(tutorId);
            System.out.println(tutor);
            List<Course> courses = tutor.getCourses();
            for (Course course : courses) {
                System.out.println(course);
            }
        } finally {
            sqlSession.close();
        }
    }
}

package com.mybatis3.service;

import com.mybatis3.domain.UserPic;
import com.mybatis3.mappers.UserPicMapper;
import com.mybatis3.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.io.*;

/**
 * Created by Administrator on 2017/3/1.
 */
public class UserPicService {
    void insertUserPic() {
        byte[] pic = null;
        try {
            File file = new File("D:\\1-1.jpg");
            InputStream is = new FileInputStream(file);
            pic = new byte[is.available()];
            is.read(pic);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = "Jack";
        String bio = "put some lenghty bio here";
        UserPic userPic = new UserPic(0, name, pic , bio);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            UserPicMapper mapper = sqlSession.getMapper(UserPicMapper.class);
            mapper.insertUserPic(userPic);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    void getUserPic() {
        UserPic userPic = null;
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            UserPicMapper mapper = sqlSession.getMapper(UserPicMapper.class);
            userPic = mapper.getUserPic(1);
        } finally {
            sqlSession.close();
        }
        byte[] pic = userPic.getPic();
        try {
            OutputStream os = new FileOutputStream(new File("D:\\1-1_FromDB.jpg"));
            os.write(pic);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

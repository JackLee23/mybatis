package com.mybatis3.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/3/1.
 */
public class UserPicServiceTest {
    static UserPicService userPicService;

    @Before
    public void setup() {
        userPicService = new UserPicService();
    }

    @After
    public void teardown() {
        userPicService = null;
    }

    @Test
    public void testInsertUserPic() {
        userPicService.insertUserPic();
    }

    @Test
    public void testGetUserPic() {
        userPicService.getUserPic();
    }
}

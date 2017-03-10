package com.mybatis3.mappers;

import com.mybatis3.domain.UserPic;

public interface UserPicMapper {
    void insertUserPic(UserPic userPic);
    UserPic getUserPic(int id);
}

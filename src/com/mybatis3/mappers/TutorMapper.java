package com.mybatis3.mappers;

import com.mybatis3.domain.Tutor;

/**
 * Created by Administrator on 2017/2/28.
 */
public interface TutorMapper {
    Tutor findTutorById(int tutorId);
}

package com.mybatis3.typehandlers;

import com.mybatis3.domain.PhoneNumber;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MyTestHandler extends BaseTypeHandler<PhoneNumber> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PhoneNumber phoneNumber, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public PhoneNumber getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}

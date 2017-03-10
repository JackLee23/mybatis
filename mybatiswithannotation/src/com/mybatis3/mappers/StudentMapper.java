package com.mybatis3.mappers;

import com.mybatis3.domain.Address;
import com.mybatis3.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    @Insert("INSERT INTO STUDENT(NAME,EMAIL,ADDR_ID, PHONE) VALUES(#{name},#{email},#{address.addrId},#{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "studId")
    int insertStudent(Student student);

    @Update("UPDATE STUDENT SET NAME=#{name}, EMAIL=#{email}, PHONE=#{phone} WHERE STUD_ID=#{studId}")
    int updateStudent(Student student);

    @Delete("DELETE FROM STUDENT WHERE STUD_ID=#{studId}")
    int deleteStudent(int studId);

    @Select("SELECT STUD_ID AS STUDID, NAME, EMAIL, PHONE FROM STUDENT WHERE STUD_ID=#{studId}")
    Student findStudentById(Integer studId);

    @Select("SELECT * FROM STUDENT")
    @Results( {
            @Result(id = true, column = "stud_id", property = "studId"),
            @Result(column = "name", property = "name"),
            @Result(column = "email", property = "email"),
            @Result(column = "addr_id", property = "address.addrId") })
    List<Student> findAllStudents();

    @Select("SELECT * FROM STUDENT WHERE STUD_ID=#{studId}")
    @ResultMap("com.mybatis3.mappers.StudentMapper.StudentResult")
    Student findStudentByIdWithResultMap(int studId);

    @Select("SELECT * FROM STUDENT")
    @ResultMap("com.mybatis3.mappers.StudentMapper.StudentResult")
    List<Student> findAllStudentsWithResultMap();

    @Select("SELECT ADDR_ID AS ADDRID, STREET, CITY, STATE, ZIP, COUNTRY FROM ADDRESSES WHERE ADDR_ID=#{id}")
    Address findAddressById(int id);

    @Select("SELECT * FROM STUDENT WHERE STUD_ID=#{studId} ")
    @Results( {
            @Result(id = true, column = "stud_id", property = "studId"),
            @Result(column = "name", property = "name"),
            @Result(column = "email", property = "email"),
            @Result(property = "address", column = "addr_id", one = @One(select = "com.mybatis3.mappers.StudentMapper.findAddressById")) })
    Student selectStudentWithAddress(int studId);
}

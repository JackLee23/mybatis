package com.mybatis3.mappers;

import com.mybatis3.domain.Address;
import com.mybatis3.domain.Course;
import com.mybatis3.domain.Tutor;
import com.mybatis3.sqlproviders.TutorDynaSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TutorMapper {
    @Select("select addr_id as addrId, street, city, state, zip, country from addresses where addr_id=#{id}")
    Address findAddressById(int id);

    @Select("select * from courses where tutor_id=#{tutorId}")
    @Results( {
            @Result(id = true, column = "course_id", property = "courseId"),
            @Result(column = "name", property = "name"),
            @Result(column = "description", property = "description"),
            @Result(column = "start_date", property = "startDate"),
            @Result(column = "end_date" , property = "endDate") })
    List<Course> findCoursesByTutorId(int tutorId);

    @Select("SELECT tutor_id, name as tutor_name, email, addr_id FROM tutors where tutor_id=#{tutorId}")
    @Results( {
            @Result(id = true, column = "tutor_id", property = "tutorId"),
            @Result(column = "tutor_name", property = "name"),
            @Result(column = "email", property = "email"),
            @Result(property = "address", column = "addr_id", one = @One(select = "com.mybatis3.mappers.TutorMapper.findAddressById")),
            @Result(property = "courses", column = "tutor_id", many = @Many(select = "com.mybatis3.mappers.TutorMapper.findCoursesByTutorId")) })
    Tutor findTutorById(int tutorId);

    @SelectProvider(type = TutorDynaSqlProvider.class, method="findTutorByIdSql")
    Tutor findTutorByIdWithDynamic(@Param("tutorId") int tutorId);

    @SelectProvider(type = TutorDynaSqlProvider.class, method = "findTutorByNameAndEmailSql")
    Tutor findTutorByNameAndEmail(@Param("name") String name, @Param("email") String email);

    @InsertProvider(type = TutorDynaSqlProvider.class, method = "insertTutor")
    @Options(useGeneratedKeys = true, keyProperty = "tutorId")
    int insertTutor(Tutor tutor);

    @UpdateProvider(type = TutorDynaSqlProvider.class, method = "updateTutor")
    int updateTutor(Tutor tutor);

    @DeleteProvider(type = TutorDynaSqlProvider.class, method = "deleteTutor")
    int deleteTutor(@Param("tutorId") int tutorId);
}

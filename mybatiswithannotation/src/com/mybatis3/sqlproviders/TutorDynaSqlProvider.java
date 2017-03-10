package com.mybatis3.sqlproviders;

import com.mybatis3.domain.Tutor;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class TutorDynaSqlProvider {
    /*public String findTutorByIdSql(int tutorId) {
        return "SELECT TUTOR_ID AS tutorId, NAME, EMAIL FROM TUTORS WHERE TUTOR_ID=" + tutorId;
    }*/

    public String findTutorByIdSql(Map<String, Object> map) {
        int tutorId = Integer.parseInt(map.get("tutorId").toString());
        return new SQL() {
            {
                SELECT("tutor_id as tutorId, name, email");
                FROM("tutors");
                WHERE("tutor_id=" + tutorId);
            }
        } .toString();
    }

    public String findTutorByIdSqlWithoutParam() {
        return new SQL() {
            {
                SELECT("tutor_id as tutorId, name, email");
                FROM("tutors");
                WHERE("tutor_id = #{tutorId}");
            }
        } .toString();
    }
    public String findTutorByNameAndEmailSql(Map<String, Object> map) {
        String name = (String) map.get("param1");
        String email = (String) map.get("param2");
        //you can also get those values using 0,1 keys
        // String name = (String) map.get("0");
        // String email = (String) map.get("1");
        return new SQL() {
            {
                SELECT("tutor_id as tutorId, name, email");
                FROM("tutors");
                WHERE("name=#{name} AND email=#{email}");
            }
        } .toString();
    }

    public String insertTutor(final Tutor tutor) {
        return new SQL() {
            {
                INSERT_INTO("TUTORS");
                if (tutor.getName() != null) {
                    VALUES("NAME", "#{name}");
                }
                if (tutor.getEmail() != null) {
                    VALUES("EMAIL", "#{email}");
                }
            }
        }.toString();
    }

    public String updateTutor(final Tutor tutor) {
        return new SQL() {
            {
                UPDATE("TUTORS");
                if (tutor.getName() != null) {
                    SET("NAME = #{name}");
                } if (tutor.getEmail() != null) {
                    SET("EMAIL = #{email}");
                }
                WHERE("TUTOR_ID = #{tutorId}");
            }
        }.toString();
    }

    public String deleteTutor(Map<String, Integer> map) {
        int tutorId = map.get("tutorId");
        return new SQL() {
            {
                DELETE_FROM("TUTORS");
                WHERE("TUTOR_ID = #{tutorId}");
            }
        }.toString();
    }
}

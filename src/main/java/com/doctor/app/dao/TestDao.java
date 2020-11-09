package com.doctor.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: doctor_signed_sys
 * @Package: com.doctor.app.dao
 * @ClassName: TestDao
 * @Author: ywj
 * @Description:
 * @Date: 2020/10/26 16:53
 */
@Mapper
@Component
public interface TestDao {

    @SelectProvider(type = GetSql.class,method = "findEntity")
    List<TestEntity> selectEntity();

    class GetSql{
        public String findEntity(){
            return new SQL(){{
                SELECT("*");
                FROM("test_entity");
            }}.toString();
        }

    }
}

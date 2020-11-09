package com.doctor.app.dao;

import com.doctor.app.entity.Basic;
import com.doctor.app.entity.Rotation;
import com.sun.istack.internal.Interned;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.dao
 * @ClassName: Common
 * @Author: gwl
 * @Description:
 * @Date: 2020/11/9 19:58
 * @Version: 1.0
 */
@Mapper
@Component
public interface CommonDao {

    @Select("select * from basic")
    Basic findAllBasic();

    @Update("update basic set corporate_name=#{corporate_name},company_url=#{company_url},title=#{title},copyright=#{copyright},record_no=#{record_no} where id=1")
    int updateBasic(Basic basic);

    @Select("select * from rotation where del=1")
    List<Rotation> findAllRotation();

    @Insert("insert into rotation values(null,#{name},#{url},#{remarks},1)")
    int insertRotation(Rotation rotation);

    @Delete("delete from rotation where id=#{id}")
    int ddelRotation(Integer id);

    @Update("update rotation set name=#{name},url=#{url},remarks=#{remarks},del=#{del} where id=#{id}")
    int updateRotation(Rotation rotation);



}

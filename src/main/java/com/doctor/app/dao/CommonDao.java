package com.doctor.app.dao;

import com.doctor.app.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: doctor_signed_sys
 * @Package: com.doctor.app.dao
 * @ClassName: CommonDao
 * @Author: gwl
 * @Description:  公共Dao
 * @Date: 2020/10/30 14:57
 * @Version: 1.0
 */

@Mapper
@Component
public interface CommonDao {

    @Select("select * from province")
    @ResultType(Province.class)
    List<Province> findAllProvince();

    @Select("select * from city")
    @ResultType(City.class)
    List<City> findAllCity();

    @Select("select * from county")
    @ResultType(County.class)
    List<County> findAllCounty();

    @Select("select * from street")
    @ResultType(Street.class)
    List<Street> findAllStreet();

    @Select("select * from community")
    @ResultType(Community.class)
    List<Community> findAllCommunity();

    //机构
    @Select("select * from organization")
    @ResultType(Organization.class)
    List<Organization> findAllOrganization();

    //科室
    @Select("select * from department")
    @ResultType(Department.class)
    List<Department> findAllDepartment();

    //职称
    @Select("select * from title")
    @ResultType(Title.class)
    List<Title> findAllTitle();

    //文化程度
    @Select("select * from education ")
    @ResultType(Education .class)
    List<Education > findAllEducation();

    //婚姻
    @Select("select * from maritalstatus ")
    @ResultType(Maritalstatus.class)
    List<Maritalstatus > findAllMaritalstatus();

    //婚姻
    @Select("select * from national")
    @ResultType(National.class)
    List<National > findAllNational();



}

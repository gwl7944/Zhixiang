package com.doctor.app.dao;

import com.doctor.app.util.CommonStr;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: doctor_signed_sys
 * @Package: com.doctor.app.dao
 * @ClassName: AppDao
 * @Author: gwl
 * @Description:
 * @Date: 2020/10/30 16:19
 * @Version: 1.0
 */
@Mapper
@Component
public interface AppDao {

    /**
     * 医生注册
     * */
    //@SelectProvider(type = GetSqls.class,method = "insertDoctor")
    @Insert("insert into doctor (doctor_name,doctor_loginname,doctor_pwd,doctor_gender,doctor_hospital,doctor_department,doctor_phone,doctor_birthday," +
            "doctor_level,doctor_worker_year,doctor_age,doctor_equipmentnumber,doctor_Integerroduce,doctor_provincecode,doctor_citycode," +
            "doctor_countycode,doctor_streetcode,doctor_communitycode,doctor_del,doctor_remarks)" +

            "values (#{doctor_name},#{doctor_loginname},#{doctor_pwd},#{doctor_gender},#{doctor_hospital},#{doctor_department},#{doctor_phone},#{doctor_birthday}," +
            "#{doctor_level},#{doctor_worker_year},#{doctor_age},#{doctor_equipmentnumber},#{doctor_Integerroduce},#{doctor_provincecode},#{doctor_citycode}," +
            "#{doctor_countycode},#{doctor_streetcode},#{doctor_communitycode},1,#{doctor_remarks})")
    int insertDoctor(Doctor doctor);

    /**
     * 医生修改
     * */
    @UpdateProvider(type = AppDao.GetSql.class,method = "updateDoctor")
    int updateDoctor(Doctor doctor);


    /**
     * 医生登录
     * */
    @Select("select * from doctor where doctor_loginname=#{doctor_loginname} and doctor_pwd=#{doctor_pwd}")
    Doctor login(Doctor doctor);

    /**
     * 医生注册校验
     * */
    @Select("select count(*) from doctor where doctor_loginname=#{loginname}")
    @ResultType(Integer.class)
    Integer checkLogin(String loginname);

    /**
     * 获取全部某医生签约患者
     * */
    //@Select("select * from patient where patient_doctorid = #{doctor_id}")
    @SelectProvider(type = AppDao.GetSql.class,method = "findPatient")
    List<Patient> findAllSignUpPatient(Patient patient);

    /**
     * 患者签约
     * */
    @Insert("insert into patient "+ CommonStr.PatientStr+" values "+CommonStr.PatientStrVal)
    @Options(useGeneratedKeys = true,keyProperty ="patient_id",keyColumn = "patient_id")
    int insertPatient(Patient patient);

    /**
     * 审核患者
     * */
    @Update("update patient set patient_issignup=#{patient_issignup},patient_signupremarks=#{patient_signupremarks} where patient_id=#{patient_id}")
    int examinePatient(Patient patient);


    /**
     * 查询医生下所有留言通道
     * */
    @Select("select mp.*,p.patient_name mp_patientid_name from message_passageway mp,patient p where mp.mp_doctorid=#{mp_doctorid} and mp.mp_patientid = p.patient_id")
    List<Message_passageway> findAllMessage(Integer mp_doctorid);

    /**
     * 获取某通道下全部聊天信息
     * */
    @Select("select * from message_information where mi_mpid=#{mi_mpid}")
    List<Message_information> findAllinformation(Integer mi_mpid);

    /**
     * 某通道下未读消息数量
     * */
    @Select("select count(mi_patientmessage) from message_information where mi_idread = 1 and mi_mpid=#{mi_mpid}")
    @ResultType(Integer.class)
    int appUnreadMessagesNum(Integer mi_mpid);

    /**
     * 医生读取某通道下患者信息状态变更
     * */
    @Update("update message_information set mi_idread=2 where mi_idread=1 and mi_mpid=#{mi_mpid} and mi_patientmessage is not null")
    int updateFormationState(Integer mi_mpid);

    /**
     * app发送消息
     * */
    @Insert("insert into message_information (mi_doctormessage,mi_messagetime,mi_idread,mi_mpid)" +
            "values (#{mi_doctormessage},NOW(),#{mi_idread},#{mi_mpid})")
    int sendMessage(Message_information messageInformation);


    class GetSql{
        public String findPatient(Patient patient){
            return new SQL(){{
                SELECT("*");
                FROM("patient");
                if (patient.getPatient_name()!=null &&!"".equals(patient.getPatient_name())){
                    WHERE("patient_doctorid ="+patient.getPatient_doctorid()+" and patient_name like concat('%','"+patient.getPatient_name()+"','%')");
                }else if (patient.getPatient_issignup()!=null&& patient.getPatient_issignup()!=0){
                    WHERE("patient_doctorid ="+patient.getPatient_doctorid()+" and patient_issignup="+patient.getPatient_issignup());
                } else {
                    WHERE("patient_doctorid ="+patient.getPatient_doctorid());
                }
            }}.toString();
        }

        public String updateDoctor(Doctor doctor){
            return new SQL(){{
               UPDATE("doctor");
               SET(CommonStr.updateDoctorKey(doctor));
               WHERE("doctor_id="+doctor.getDoctor_id());
            }}.toString();
        }

    }


}

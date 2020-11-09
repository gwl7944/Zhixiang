package com.doctor.app.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: doctor_signed_sys
 * @Package: com.doctor.app.dao
 * @ClassName: AppletsDao
 * @Author: gwl
 * @Description:
 * @Date: 2020/11/9 9:57
 * @Version: 1.0
 */
@Mapper
@Component
public interface AppletsDao {

     /**
      * 查询医生列表
      * */
     @Select("select d.* from doctor d,patient p where d.doctor_communitycode = p.patient_communitycode and p.patient_id=#{patient_id} ")
     List<Doctor> findDoctorBypatient_communitycode(Integer patient_id);

    /**
     * 查询医生
     * */
     @Select("select * from doctor where doctor_id=#{doctor_id}")
     Doctor findDoctorById(Integer doctor_id);

    /**
     * 查询患者
     * */
     @Select("select * from patient where patient_id=#{patient_id}")
     Patient findPatientById(Integer patient_id);

    /**
     * 删除患者
     * */
     @Delete("delete from patient where patient_id=#{patient_id}")
     int delPatient(Integer patient_id);

    /**
     * 查询患者下所有留言通道
     * */
    @Select("select mp.*,d.doctor_name mp_doctorid_name from message_passageway mp,doctor d where mp.mp_patientid=#{mp_patientid} and mp.mp_doctorid = d.doctor_id")
    List<Message_passageway> findAllMessage(Integer mp_patientid);



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
     * 患者读取某通道下患者信息状态变更
     * */
    @Update("update message_information set mi_idread=2 where mi_idread=1 and mi_mpid=#{mi_mpid} and mi_doctormessage is not null")
    int updateFormationState(Integer mi_mpid);


    /**
     * 小程序发送消息
     * */
    @Insert("insert into message_information (mi_patientmessage,mi_messagetime,mi_idread,mi_mpid)" +
            "values (#{mi_patientmessage},NOW(),#{mi_idread},#{mi_mpid})")
    int sendMessage(Message_information messageInformation);

}

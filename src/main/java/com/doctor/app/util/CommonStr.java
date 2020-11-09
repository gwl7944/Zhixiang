package com.doctor.app.util;

import cn.hutool.core.util.StrUtil;

/**
 * @ProjectName: doctor_signed_sys
 * @Package: com.doctor.app.util
 * @ClassName: CommonStr
 * @Author: gwl
 * @Description:
 * @Date: 2020/11/2 15:42
 * @Version: 1.0
 */


public class CommonStr {

    public static final String PatientStr = "(patient_name,patient_gender,patient_age,patient_birthday,patient_address,patient_idnumber,patient_phone," +
            "patient_open_id,patient_householdreg,patient_provincecode,patient_citycode,patient_countycode,patient_streetcode,patient_communitycode,patient_nationalcode," +
            "patient_educationcode,patient_maritalstatuscode,patient_signuptype,patient_signupnumber,patient_issignup,patient_doctorid,patient_doctorname,patient_signupremarks," +
            "patient_idcardpositive,patient_idcardback,patient_facephoto,patient_signupdate,patient_remarks,patient_del)";
    public static final String PatientStrVal = "(#{patient_name},#{patient_gender},#{patient_age},#{patient_birthday},#{patient_address},#{patient_idnumber},#{patient_phone}," +
            "#{patient_open_id},#{patient_householdreg},#{patient_provincecode},#{patient_citycode},#{patient_countycode},#{patient_streetcode},#{patient_communitycode},#{patient_nationalcode}," +
            "#{patient_educationcode},#{patient_maritalstatuscode},#{patient_signuptype},#{patient_signupnumber},#{patient_issignup},#{patient_doctorid},#{patient_doctorname},#{patient_signupremarks}," +
            "#{patient_idcardpositive},#{patient_idcardback},#{patient_facephoto},#{patient_signupdate},#{patient_remarks},#{patient_del})";

    public static String updateDoctorKey(Doctor doctor){
        StringBuffer sb = new StringBuffer();
        if (doctor.getDoctor_name()!=null){
            sb.append("doctor_name='"+doctor.getDoctor_name()+"',");
        }
        if (doctor.getDoctor_loginname()!=null){
            sb.append("doctor_loginname='"+doctor.getDoctor_loginname()+"',");
        }
        if (doctor.getDoctor_pwd()!=null){
            sb.append("doctor_pwd='"+doctor.getDoctor_pwd()+"',");
        }
        if (doctor.getDoctor_gender()!=null){
            sb.append("doctor_gender='"+doctor.getDoctor_gender()+"',");
        }
        if (doctor.getDoctor_hospital()!=null){
            sb.append("doctor_hospital="+doctor.getDoctor_hospital()+",");
        }
        if (doctor.getDoctor_department()!=null){
            sb.append("doctor_department="+doctor.getDoctor_department()+",");
        }
        if (doctor.getDoctor_phone()!=null){
            sb.append("doctor_phone='"+doctor.getDoctor_phone()+"',");
        }
        if (doctor.getDoctor_birthday_str()!=null){
            sb.append("doctor_birthday='"+doctor.getDoctor_birthday_str()+"',");
        }
        if (doctor.getDoctor_level()!=null){
            sb.append("doctor_level="+doctor.getDoctor_level()+",");
        }
        if (doctor.getDoctor_worker_year()!=null){
            sb.append("doctor_worker_year="+doctor.getDoctor_worker_year()+",");
        }
        if (doctor.getDoctor_age()!=null){
            sb.append("doctor_age="+doctor.getDoctor_age()+",");
        }
        if (doctor.getDoctor_Integerroduce()!=null){
            sb.append("doctor_Integerroduce='"+doctor.getDoctor_Integerroduce()+"',");
        }
        if (doctor.getDoctor_provincecode()!=null){
            sb.append("doctor_provincecode="+doctor.getDoctor_provincecode()+",");
        }
        if (doctor.getDoctor_citycode()!=null){
            sb.append("doctor_citycode="+doctor.getDoctor_citycode()+",");
        }
        if (doctor.getDoctor_countycode()!=null){
            sb.append("doctor_countycode="+doctor.getDoctor_countycode()+",");
        }
        if (doctor.getDoctor_streetcode()!=null){
            sb.append("doctor_streetcode="+doctor.getDoctor_streetcode()+",");
        }
        if (doctor.getDoctor_communitycode()!=null){
            sb.append("doctor_communitycode="+doctor.getDoctor_communitycode()+",");
        }
        if (doctor.getDoctor_remarks()!=null){
            sb.append("doctor_remarks='"+doctor.getDoctor_remarks()+"',");
        }
        String s = StrUtil.subWithLength(sb.toString(), 0, sb.toString().length() - 1);
        return s;
    }


}

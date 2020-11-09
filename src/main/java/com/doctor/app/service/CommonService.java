package com.doctor.app.service;

import com.doctor.app.entity.Basic;
import com.doctor.app.entity.Rotation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.service
 * @ClassName: CommonService
 * @Author: gwl
 * @Description:
 * @Date: 2020/11/9 20:12
 * @Version: 1.0
 */
public interface CommonService {

    Basic getAllBasic();

    int updateBasic(Basic basic);

    List<Rotation> getAllRotation();

    int insertRotation(Rotation rotation);

    int ddelRotation(Integer id);

    int updateRotation(Rotation rotation);
}

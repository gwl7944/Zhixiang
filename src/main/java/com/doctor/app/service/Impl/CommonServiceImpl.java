package com.doctor.app.service.Impl;


import com.doctor.app.dao.CommonDao;
import com.doctor.app.entity.Basic;
import com.doctor.app.entity.Rotation;
import com.doctor.app.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.service.Impl
 * @ClassName: CommonServiceImpl
 * @Author: gwl
 * @Description:
 * @Date: 2020/11/9 20:12
 * @Version: 1.0
 */

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonDao commonDao;

    @Override
    public Basic getAllBasic() {
        return commonDao.findAllBasic();
    }

    @Override
    public int updateBasic(Basic basic) {
        return commonDao.updateBasic(basic);
    }

    @Override
    public List<Rotation> getAllRotation() {
        return commonDao.findAllRotation();
    }

    @Override
    public int insertRotation(Rotation rotation) {
        return commonDao.insertRotation(rotation);
    }

    @Override
    public int ddelRotation(Integer id) {
        return commonDao.ddelRotation(id);
    }

    @Override
    public int updateRotation(Rotation rotation) {
        return commonDao.updateRotation(rotation);
    }
}

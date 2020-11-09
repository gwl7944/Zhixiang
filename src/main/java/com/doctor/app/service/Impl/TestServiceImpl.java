package com.doctor.app.service.Impl;

import com.doctor.app.dao.TestDao;
import com.doctor.app.entity.User;
import com.doctor.app.service.TesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: doctor_signed_sys
 * @Package: com.doctor.app.service.Impl
 * @ClassName: TestServiceImpl
 * @Author: ywj
 * @Description:
 * @Date: 2020/10/26 16:52
 */
@Service
public class TestServiceImpl implements TesService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<User> getEntity() {

        List<User> list = testDao.selectEntity();
        return list;
    }
}

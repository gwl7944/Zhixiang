package com.doctor.app.service.Impl;

import com.doctor.app.dao.ContentDao;
import com.doctor.app.entity.Content;
import com.doctor.app.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: app
 * @Package: com.doctor.app.service.Impl
 * @ClassName: ContentServiceImpl
 * @Author: ywj
 * @Description:
 * @Date: 2020/11/9 20:33
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao contentDao;

    @Override
    public int insertContent(Content content) {

        int  i = contentDao.insertContent(content);

        return i;
    }

    @Override
    public int updateContentSql(Content content) {

        int  i = contentDao.updateContentSql(content);
        return i;
    }
}

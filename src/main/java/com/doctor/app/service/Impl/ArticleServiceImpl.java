package com.doctor.app.service.Impl;

import com.doctor.app.dao.ArticleDao;
import com.doctor.app.entity.Column;
import com.doctor.app.service.ArticleService;
import com.doctor.app.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.service.Impl
 * @ClassName: ArticleServiceImpl
 * @Author: gwl
 * @Description:
 * @Date: 2020/11/9 20:38
 * @Version: 1.0
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public Page<Column> getAllColumn(Integer CurrentPage) {

        Page<Column> page = new Page<>();
        PageHelper.startPage(CurrentPage,10);
        List<Column> columns = articleDao.finaAllColumn();
        PageInfo<Column> info = new PageInfo<>(columns);
        page.setCurrentnumber(info.getPageNum());
        page.setCurrentpage(CurrentPage);
        page.setPagecount(info.getPages());
        page.setTotalnumber((int) info.getTotal());
        page.setDatalist(info.getList());
        return page;
    }

    @Override
    public Column getColumnBuId(Integer id) {
        return articleDao.findColumnBuId(id);
    }

    @Override
    public int updateColumn(Column column) {
        return articleDao.updateColumn(column);
    }

    @Override
    public int insertColumn(Column column) {
        return articleDao.insertColumn(column);
    }

    @Override
    public int deleteColumn(Integer id) {
        return articleDao.deleteColumn(id);
    }
}

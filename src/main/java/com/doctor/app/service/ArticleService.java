package com.doctor.app.service;

import com.doctor.app.entity.Column;
import com.doctor.app.util.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.service
 * @ClassName: ArticleService
 * @Author: gwl
 * @Description:
 * @Date: 2020/11/9 20:37
 * @Version: 1.0
 */
public interface ArticleService {

    Page<Column> getAllColumn(Integer CurrentPage);

    Column getColumnBuId(Integer id);

    int updateColumn(Column column);

    int insertColumn(Column column);

    int deleteColumn(Integer id);
}

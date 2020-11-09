package com.doctor.app.dao;

import com.doctor.app.entity.Content;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ProjectName: app
 * @Package: com.doctor.app.dao
 * @ClassName: ContentDao
 * @Author: ywj
 * @Description:
 * @Date: 2020/11/9 20:35
 */
@Mapper
public interface ContentDao {
    int insertContent(Content content);

    int updateContentSql(Content content);
}

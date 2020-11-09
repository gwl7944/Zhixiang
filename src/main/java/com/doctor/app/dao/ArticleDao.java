package com.doctor.app.dao;

import com.doctor.app.entity.Column;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.dao
 * @ClassName: ArticleDao
 * @Author: gwl
 * @Description:  内容和文章
 * @Date: 2020/11/9 20:23
 * @Version: 1.0
 */
@Mapper
@Component
public interface ArticleDao {

     @Select("select * from column")
     List<Column> finaAllColumn();

     @Select("select * from column where id=#{id}")
     Column findColumnBuId(Integer id);

     @Update("update column set name=#{name},level=#{level},type=#{type} where = id=#{id}")
     int updateColumn(Column column);

     @Insert("insert into column values(null,#{name},#{level},#{type},1)")
     int insertColumn(Column column);

     @Update("update column set del=2 where id=#{id}")
     int deleteColumn(Integer id);

}

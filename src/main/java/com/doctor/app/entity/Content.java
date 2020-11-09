package com.doctor.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.entity
 * @ClassName: Content
 * @Author: gwl
 * @Description:  内容
 * @Date: 2020/11/9 19:27
 * @Version: 1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {

    private Integer id;
    private String title;
    private Integer column_id;
    private String column_name;
    private String views;
    private String releasedate;
    private String num;
    private String Abbreviation_url;
    private String details;
    private String atlas;
    private String name;
    private String phone;
    private Integer del;
}

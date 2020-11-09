package com.doctor.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.entity
 * @ClassName: Column
 * @Author: gwl
 * @Description: 栏目
 * @Date: 2020/11/9 19:25
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Column {

    private Integer id;
    private String name;
    private String level;
    private String type;
    private Integer del;
}

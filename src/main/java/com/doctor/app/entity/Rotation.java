package com.doctor.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.entity
 * @ClassName: Rotation
 * @Author: gwl
 * @Description:  轮播设置
 * @Date: 2020/11/9 19:18
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rotation {

    private Integer id;
    private String name;
    private String url;
    private String remarks;
    private Integer del;

}

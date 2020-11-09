package com.doctor.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: app
 * @Package: com.doctor.app.entity
 * @ClassName: User
 * @Author: ywj
 * @Description:
 * @Date: 2020/11/9 18:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String user_name;
    private String user_pwd;
    private String user_phone;
    private Integer user_del;

}

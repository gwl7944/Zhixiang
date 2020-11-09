package com.doctor.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * @ProjectName: app
 * @Package: com.doctor.app.controller
 * @ClassName: UserController
 * @Author: ywj
 * @Description:
 * @Date: 2020/11/9 18:51
 */
@RestController
public class UserController {


    @RequestMapping("/userLogin")
    @ResponseBody
    public String getHello(@RequestParam("user_name") String user_name,@RequestParam("user_pwd") String user_pwd){



        return "";
    }

}

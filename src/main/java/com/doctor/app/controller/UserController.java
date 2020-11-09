package com.doctor.app.controller;

import com.alibaba.fastjson.JSON;
import com.doctor.app.entity.User;
import com.doctor.app.service.UserService;
import com.doctor.app.util.ResultCode;
import com.doctor.app.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @Autowired
    private UserService userService;

    /**
     * 用户登录校验
     */
    @RequestMapping("/userLogin")
    public JSON getHello(@RequestParam("user_name") String user_name, @RequestParam("user_pwd") String user_pwd){

        boolean b =  userService.userLogin(user_name,user_pwd);
        if (b){
            return ResultData.getResponseData(b,ResultCode.LOGIN_SUCCESS);
        }
        return ResultData.getResponseData(b,ResultCode.USER_PWD_ERROR);
    }

    /**
     * 用户新增
     */
    @RequestMapping(value = "/setUser",method = RequestMethod.POST)
    public JSON setUser(@ModelAttribute User user){

        int i = userService.insertUser(user);
        if (i>0){
            return ResultData.getResponseData(i,ResultCode.INSERT_SUCCESS); //503
        }
        return ResultData.getResponseData(i,ResultCode.INSERT_ERROR); //503
    }

    /**
     * 全查用户
     */
    @RequestMapping("getAllUser")
    public JSON getAllUser(){

        List<User> allUser = userService.selectAllUser();
        if (allUser.size()>0){
            return ResultData.getResponseData(allUser,ResultCode.QUERY_SUCCESS); //503
        }
        return ResultData.getResponseData(null,ResultCode.QUERY_ERROR); //503
    }

    /**
     * 根据ID 查询 User
     */
    @RequestMapping("getUserById")
    public JSON getUserById(@RequestParam("id") Integer id){
        User user = userService.selectUserById(id);
        if (user!=null){
            return ResultData.getResponseData(user,ResultCode.QUERY_SUCCESS); //503
        }
        return ResultData.getResponseData(null,ResultCode.QUERY_ERROR); //503
    }

    /**
    * 更新用户
     */
    @RequestMapping("/updateUser")
    public JSON updateUser(@ModelAttribute User user){

        int i = userService.updateUserSql(user);
        if (i>0){
            return ResultData.getResponseData(i,ResultCode.INSERT_SUCCESS); //503
        }
        return ResultData.getResponseData(i,ResultCode.INSERT_ERROR); //503
    }

    /**
     * 删除用户
     */
    @RequestMapping("/deleteUser")
    public JSON deleteUser(@RequestParam("id") Integer id){

        int i = userService.deleteUserSql(id);
        if (i>0){
            return ResultData.getResponseData(i,ResultCode.INSERT_SUCCESS); //503
        }
        return ResultData.getResponseData(i,ResultCode.INSERT_ERROR); //503
    }



}

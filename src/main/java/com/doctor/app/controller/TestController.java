package com.doctor.app.controller;

import com.doctor.app.service.TesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @ProjectName: doctor_signed_sys
 * @Package: com.doctor.app.testcontroller
 * @ClassName: TestController
 * @Author: ywj
 * @Description:
 * @Date: 2020/10/26 15:31
 */
@Controller
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private TesService tesService;

    @RequestMapping("/hello")
    @ResponseBody
    public List<TestEntity> getHello(){

        List<TestEntity> testEntityList = tesService.getEntity();

        return testEntityList;
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public String getHello2(){
        System.out.println(123);
        return "hello";
    }
}

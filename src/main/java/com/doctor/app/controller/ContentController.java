package com.doctor.app.controller;

import com.alibaba.fastjson.JSON;
import com.doctor.app.entity.Content;
import com.doctor.app.service.ContentService;
import com.doctor.app.util.ResultCode;
import com.doctor.app.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: app
 * @Package: com.doctor.app.controller
 * @ClassName: ContentController
 * @Author: ywj
 * @Description:
 * @Date: 2020/11/9 20:29
 */
@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;


    /**
     * 插入内容
     */
    @RequestMapping(value = "/setContent",method = RequestMethod.POST)
    public JSON setContent(@ModelAttribute Content content){

        int i =  contentService.insertContent(content);
        if (i>0){
            return ResultData.getResponseData(i,ResultCode.INSERT_SUCCESS); //503
        }
        return ResultData.getResponseData(i,ResultCode.INSERT_ERROR); //
    }

    /**
     * 更新内容
     */
    @RequestMapping(value = "/updateContent",method = RequestMethod.POST)
    public JSON updateContent(@ModelAttribute Content content){

        int i =  contentService.updateContentSql(content);

        if (i>0){
            return ResultData.getResponseData(i,ResultCode.INSERT_SUCCESS); //503
        }
        return ResultData.getResponseData(i,ResultCode.INSERT_ERROR); //
    }

}

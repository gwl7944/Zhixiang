package com.doctor.app.controller;

import com.alibaba.fastjson.JSON;
import com.doctor.app.entity.Column;
import com.doctor.app.service.ArticleService;
import com.doctor.app.util.Page;
import com.doctor.app.util.ResultCode;
import com.doctor.app.util.ResultData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.controller
 * @ClassName: ArticleController
 * @Author: gwl
 * @Description:
 * @Date: 2020/11/9 20:46
 * @Version: 1.0
 */

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @GetMapping("/ArticleController/finaAllColumn/{CurrentPage}")
    public JSON  finaAllColumn(@PathVariable("CurrentPage") Integer CurrentPage){
        Page<Column> allColumn = articleService.getAllColumn(CurrentPage);
        return ResultData.getResponseData(allColumn, ResultCode.QUERY_SUCCESS);
    }

    @GetMapping("/ArticleController/findColumnBuId/{id}")
    public JSON  findColumnBuId(@PathVariable("id") Integer id){
        Column columnBuId = articleService.getColumnBuId(id);
        return ResultData.getResponseData(columnBuId, ResultCode.QUERY_SUCCESS);
    }

    @PostMapping("/ArticleController/updateColumn")
    public JSON  updateColumn(@ModelAttribute Column column){
        int i = articleService.updateColumn(column);
        if (i>0){
            return ResultData.getResponseData(null, ResultCode.UPDATE_SUCCESS);
        }else {
            return ResultData.getResponseData(null, ResultCode.UPDATE_ERROR);
        }
    }

    @PostMapping("/ArticleController/insertColumn")
    public JSON insertColumn(@ModelAttribute Column column){
        int i = articleService.insertColumn(column);
        if (i>0){
            return ResultData.getResponseData(null, ResultCode.INSERT_SUCCESS);
        }else {
            return ResultData.getResponseData(null, ResultCode.INSERT_ERROR);
        }
    }

    @GetMapping("/ArticleController/deleteColumn/{id}")
    public JSON deleteColumn(@PathVariable("id") Integer id){
        int i = articleService.deleteColumn(id);
        if (i>0){
            return ResultData.getResponseData(null, ResultCode.DELETE_SUCCESS);
        }else {
            return ResultData.getResponseData(null, ResultCode.DELETE_ERROR);
        }
    }


}

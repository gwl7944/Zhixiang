package com.doctor.app.controller;


import com.alibaba.fastjson.JSON;
import com.doctor.app.entity.Basic;
import com.doctor.app.entity.Rotation;
import com.doctor.app.service.CommonService;
import com.doctor.app.util.FastDFSUtils;
import com.doctor.app.util.ResultCode;
import com.doctor.app.util.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ProjectName: Zhixiang
 * @Package: com.doctor.app.controller
 * @ClassName: CommonController
 * @Author: gwl
 * @Description:
 * @Date: 2020/11/9 20:15
 * @Version: 1.0
 */

@RestController
@Slf4j
public class CommonController {

    @Autowired
    CommonService commonService;

    @Value("${serveraddress}")
    private String serveraddress;

    /**
     * 查找基本信息
     * */
    @GetMapping("/CommonController/findAllBasic")
    public JSON findAllBasic(){
        Basic allBasic = commonService.getAllBasic();
        return ResultData.getResponseData(allBasic, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 修改基本信息
     * */
    @PostMapping("/CommonController/updateBasic")
    public JSON updateBasic(@ModelAttribute Basic basic){
        int i = commonService.updateBasic(basic);
        if (i>0){
            return ResultData.getResponseData(null, ResultCode.UPDATE_SUCCESS);
        }else {
            return ResultData.getResponseData(null, ResultCode.UPDATE_ERROR);
        }
    }


    /**
     * 查找轮播
     * */
    @GetMapping("/CommonController/findAllRotation")
    public JSON findAllRotation(){
        List<Rotation> allRotation = commonService.getAllRotation();
        return ResultData.getResponseData(allRotation, ResultCode.QUERY_SUCCESS);

    }


    /**
     * 新增轮播
     * */
    @PostMapping("/CommonController/insertRotation")
    public JSON insertRotation(@ModelAttribute Rotation rotation){
        int i = commonService.insertRotation(rotation);
        if (i>0){
            return ResultData.getResponseData(null, ResultCode.INSERT_SUCCESS);
        }else {
            return ResultData.getResponseData(null, ResultCode.INSERT_ERROR);
        }
    }


    /**
     * 删除轮播
     * */
    @GetMapping("/CommonController/ddelRotation/{id}")
    public JSON ddelRotation(@PathVariable("id") Integer id){
        int i = commonService.ddelRotation(id);
        if (i>0){
            return ResultData.getResponseData(null, ResultCode.DELETE_SUCCESS);
        }else {
            return ResultData.getResponseData(null, ResultCode.DELETE_ERROR);
        }
    }


    /**
     * 修改轮播
     * */
    @PostMapping("/CommonController/updateRotation")
    public JSON updateRotation(@ModelAttribute Rotation rotation){
        int i = commonService.updateRotation(rotation);
        if (i>0){
            return ResultData.getResponseData(null, ResultCode.UPDATE_SUCCESS);
        }else {
            return ResultData.getResponseData(null, ResultCode.UPDATE_ERROR);
        }
    }


    /**
     * 图片上传
     * */
    @PostMapping("/CommonController/IMG")
    public JSON insertCommodityIMG(MultipartFile file){
        log.info("serveraddress------>"+serveraddress);
        String fileId = FastDFSUtils.upload(file);
        String url = serveraddress + fileId;
        if(url!=null){
            return ResultData.getResponseData(url,ResultCode.IMG_SUCCESS);
        }else {
            return ResultData.getResponseData(null,ResultCode.IMG_ERROR);
        }
    }

}

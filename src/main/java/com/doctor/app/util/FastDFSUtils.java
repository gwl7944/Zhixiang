package com.doctor.app.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ProjectName: cloudTX
 * @Package: com.web.util
 * @ClassName: FastDFSUtils
 * @Author: gwl
 * @Description:
 * @Date: 2020/9/27 9:39
 * @Version: 1.0
 */


public class FastDFSUtils {

    private static StorageClient client1;

    static {
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            client1 = new StorageClient(trackerServer,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  String upload(MultipartFile file) {
        String oldName = file.getOriginalFilename();
        try {
            String[] strings = client1.upload_file(file.getBytes(), oldName.substring(oldName.lastIndexOf(".") + 1), null);
            String fileName="";
            for (String str:strings){
                //System.out.println("Name:----"+str);
                fileName+="/"+str;
            }
            return fileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

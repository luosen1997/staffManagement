package com.etc.util;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.etc.model.Document;

public class UploadFileUtil {

    public static void UploadFile(HttpServletRequest req, Document document, MultipartFile docFile) throws Exception {
         System.out.println("进入上传方法了");
        System.out.println(document);

        System.out.println(docFile);


        //获取上传文件的名称
        String fileName =docFile.getOriginalFilename();
        // System.out.println("文件名称:"+fileName);

        String tn=new Date().getTime()+"";
        //分割名字
        int len=fileName.lastIndexOf(".");
        String suffix=fileName.substring(len);
        //输出文件后缀
        System.out.println(suffix);
        //新的文件名字
        String newFileName=tn + suffix;

        String realPath="d:/AAtest/";

        File file=new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        File file2=new File(realPath+newFileName);
        //设置文件的真实路径
        document.setDocumentPath(realPath+newFileName);
        //写入文件
        docFile.transferTo(file2);

    }
}

package com.etc.controller;

import com.etc.model.Document;
import com.etc.service.DocumentService;
import com.etc.util.UploadFileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/document")
@MultipartConfig
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    private ObjectMapper objectMapper=new ObjectMapper();

    @RequestMapping("/getDocumentList")
    @ResponseBody
    public Map<String,Object> getDocumentList(Integer page, Integer limit, String searchParams) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();

       Document document=new Document();//查询条件
        if(searchParams!=null){
            //将字符串转化为java对象
            document=objectMapper.readValue(searchParams,Document.class);
        }

        //查询总的数据条数
        int count=documentService.getDocumentListCount(document);
//        System.out.println("文档数据的总条数为:"+count);
        //分页查询出文档列表信息
        List<Document> documentList=documentService.getDocumentListByPage(document,page,limit);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",documentList);
        return map;
    }



    @RequestMapping(value = "/documentUpload",method = RequestMethod.POST)
    public String documentUpdate(HttpServletRequest req, Document document, MultipartFile docFile) throws Exception{

        UploadFileUtil.UploadFile(req,document,docFile);
        if(documentService.addDocument(document)){
            return "document/document-list";
        }

        return null;
    }



    @RequestMapping("/showDocument")
    public String getDocumentById(Integer id, Model model){
//        System.out.println("id="+id);
        Document document=documentService.getDocumentById(id);
        model.addAttribute("document",document);
        return "document/document-edit";
    }


    @RequestMapping(value = "/documentUpdate",method = RequestMethod.POST)
    public String documentUpload(HttpServletRequest req, Document document, MultipartFile docFile) throws Exception{
        UploadFileUtil.UploadFile(req,document,docFile);
        if(documentService.updateDocument(document)){
            return "document/document-list";
        }

        return null;
    }


    @RequestMapping("/documentDelete")
    @ResponseBody
    public Map<String,Object> documentDelete(String ids){
        Map<String,Object> map=new HashMap<String, Object>();
//        System.out.println(ids);
        map.put("code","1002");
        map.put("msg","error");
        if(documentService.deleteDocument(ids)){
            map.put("code","1001");
            map.put("msg","success");
        }
        return map;
    }


    //这是文件下载操作
    @RequestMapping("/documentDownLoad")
    public void documentDownLoad(Integer id, HttpServletResponse resp,HttpServletRequest req) throws Exception {

        Document document=documentService.getDocumentById(id);
        //根据文件名及路径转为文件
        String path=document.getDocumentPath();
        File file=new File(path);
//        System.out.println(file);

        //将文件转为输入流
        FileInputStream fis = new FileInputStream(file);
        //分割名字
        String fileName1 = path.substring(path.lastIndexOf("/")+1);

        // 设置响应头
        resp.setContentType("application/x-msdownload");
        // 解决下载中名字为中文出现乱码的问题
        resp.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName1.getBytes(), "ISO-8859-1"));


        ServletOutputStream outputStream=resp.getOutputStream();

        int len=0;
        byte[] buffer=new byte[1024];

        while((len =fis.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        outputStream.close();
        fis.close();

    }

}

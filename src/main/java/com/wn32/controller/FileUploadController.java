package com.wn32.controller;

import com.wn32.exception.Wn32Exception;
import com.wn32.utils.UuidUtils;
import javafx.scene.Parent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FileUploadController {
    @RequestMapping("/fileUpload")
    public String detailFileUpLoad(MultipartFile uploadFile, HttpServletRequest request) throws IOException, Wn32Exception {
//        ////测试全局异常处理
//        System.out.println("抛出自定义异常");
//        throw new Wn32Exception();

        //准备名字
        String uploadFileName = uploadFile.getOriginalFilename();
        String fileName = uploadFileName.substring(0,uploadFileName.lastIndexOf("."));
        String suffix = uploadFileName.substring(uploadFileName.lastIndexOf("."));
        fileName = fileName + UuidUtils.getUuid32() + suffix;

        //准备路径
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("upload");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateTime = simpleDateFormat.format(new Date());

        File parent = new File(realPath+File.separator+dateTime);
        if (!parent.exists()){
            parent.mkdirs();
        }

        //目标文件
        File target = new File(parent,fileName);
        uploadFile.transferTo(target);
        return "list";


    }
}

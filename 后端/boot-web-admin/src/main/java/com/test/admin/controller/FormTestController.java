package com.test.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 */
@Slf4j

@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "/form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param username
     * @param heardImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile heardImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息:email={},username={},headerImg={},photos={}",email,username,heardImg.getSize(),photos.length);//查看上传信息，打印到控制台

        if (!heardImg.isEmpty()){
            //保存到文件服务器，oss服务器
            String Filename = heardImg.getOriginalFilename();
            heardImg.transferTo(new File("C:\\java\\"+Filename));//1.注意要在java后面加两个//2.java表示的是一个文件夹，后面的Filename表示创建一个File的名字叫Filename
        }
        if (photos.length > 0){
            for (MultipartFile photo : photos){
                if (!photo.isEmpty()){
                    String Filename = photo.getOriginalFilename();
                    photo.transferTo(new File("C:\\java\\"+Filename));
                }
            }
        }

        return "main";
    }

}

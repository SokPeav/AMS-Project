package com.example.demo.Controller;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@PropertySource("classpath:ams.properties")
public class FileUploadController {

    @GetMapping("/upload")
    public String upload()
    {
        return "upload";
    }

    @PostMapping("/uploads")
    public String saveUpload(@RequestParam("file") MultipartFile file){
        if(!file.isEmpty())
        {
            System.out.println(file.getOriginalFilename());
            String nameFile = UUID.randomUUID().toString() + file.getOriginalFilename();
            try {
                Files.copy(file.getInputStream(), Paths.get("C:\\Users\\TRC\\Desktop\\Image", nameFile ));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:upload";
    }
}

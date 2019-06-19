package com.example.demo.Configuration.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@PropertySource("classpath:ams.properties")
public class FileUploadConfiguration implements WebMvcConfigurer {

//    @Value("${file.images.path}")
//    String path ;
//    @Value("${file.images.client}")
    String client = "file:" + System.getProperty("user.dir") + "/src/main/resources/images/";
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( "/images/**").addResourceLocations(client);
    }
}

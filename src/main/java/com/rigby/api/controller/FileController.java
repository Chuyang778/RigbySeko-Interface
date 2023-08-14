package com.rigby.api.controller;

import com.rigby.api.utils.OSSUtils;
import com.rigby.apicommon.BaseResponse;
import com.rigby.apicommon.Utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ChuYang
 * @version 1.0
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Autowired
    private OSSUtils ossUtils;

    @PostMapping("/upload")
    public BaseResponse<String> upload(MultipartFile multipartFile) throws IOException{
        log.info("文件上传, 文件名为{}",multipartFile.getOriginalFilename());
        String url = ossUtils.upload(multipartFile);
        log.info("url:{}",url);
        return ResultUtils.success(url);
    }
}

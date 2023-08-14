package com.rigby.api.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author ChuYang
 * @version 1.0
 */
@Slf4j
@Component
public class OSSUtils {

    @Value("${OSS.Endpoint}")
    private String Endpoint;

    @Value("${OSS.AccessKeyId}")
    private String AccessKeyId;

    @Value("${OSS.SecretKeyId}")
    private String SecretKeyId;

    @Value("${OSS.BucketName}")
    private String BucketName;

    private OSS getOSS(){
        return new OSSClientBuilder().build(Endpoint, AccessKeyId, SecretKeyId);
    }

    public String upload(MultipartFile file) throws IOException{
        OSS ossClient = getOSS();
        InputStream inputStream = file.getInputStream();

        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        ossClient.putObject(BucketName, fileName,inputStream);
        String url = Endpoint.split("//")[0] + "//" + BucketName + "." + Endpoint.split("//")[1] + "/" + fileName;
        ossClient.shutdown();
        return url;
    }

}

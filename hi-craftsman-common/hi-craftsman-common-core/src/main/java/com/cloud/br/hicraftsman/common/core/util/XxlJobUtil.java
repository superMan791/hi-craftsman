//package com.cloud.br.hicraftsman.common.core.util;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.Map;
//
///**
// * @author yzp
// * @date 2021/2/22 19:42
// */
//@Slf4j
//@Component
//public class XxlJobUtil {
//    @Value("${xxl.update.url}")
//    private String url;
//    @Value("${xxl.update.platCode}")
//    private String platCode;
//    @Value("${xxl.job.executor.appname}")
//    private String appName;
//    private static final RestTemplate restTemplate=new RestTemplate();
//
//    /***
//     *
//     * @param jobInfoId  job的id, 到xxl-job控制台查看,地址: http://job-admin.paas-sit.haier.net/job-admin/sso/toSsoLogin  账号: A0044523 密码是: Yzp15672,.
//     * @param  jobCron  定时任务表达式
//     * @return  java.lang.Boolean
//     * @author yzp
//     * @date 2021/2/22 20:22
//     */
//    public Boolean update(Integer jobInfoId,String jobCron){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        MultiValueMap<String,Object> params=new LinkedMultiValueMap<>();
//        params.add("platCode", Base64.getEncoder().encodeToString(platCode.getBytes(StandardCharsets.UTF_8)));
//        params.add("appName",appName);
//        params.add("jobInfoId",jobInfoId);
//        params.add("jobCron",jobCron);
//        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(
//                params, headers);
//        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(url, request, Map.class);
//        Map<String,Object> result=responseEntity.getBody();
//        if(result!=null&&result.get("code")!=null&&(Integer)result.get("code")==200){
//            return true;
//        }
//        return false;
//    }
//
//}
//

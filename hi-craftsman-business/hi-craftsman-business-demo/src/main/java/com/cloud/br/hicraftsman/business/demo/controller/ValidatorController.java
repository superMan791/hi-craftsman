package com.cloud.br.hicraftsman.business.demo.controller;

import com.cloud.br.hicraftsman.business.demo.domain.dto.BscDictInfoDto;
import com.cloud.br.hicraftsman.common.core.base.R;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 参数校验
 */
@RestController
@RequestMapping("validator")
public class ValidatorController {
    @Resource
    private ObjectMapper objectMapper;

    @PostMapping("insert")
    public R<Boolean> insert(@Validated @RequestBody BscDictInfoDto bscDictInfoDto) throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(bscDictInfoDto));
        return R.ok();
    }
}

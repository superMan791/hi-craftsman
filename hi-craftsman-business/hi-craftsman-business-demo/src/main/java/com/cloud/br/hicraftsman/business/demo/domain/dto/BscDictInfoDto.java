package com.cloud.br.hicraftsman.business.demo.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BscDictInfoDto {
    @NotBlank(message = "字典名称不能为空")
    private String name;
    private String desc;
}

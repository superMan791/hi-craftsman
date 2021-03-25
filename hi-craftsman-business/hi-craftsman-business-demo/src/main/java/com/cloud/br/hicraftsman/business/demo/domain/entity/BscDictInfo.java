package com.cloud.br.hicraftsman.business.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BscDictInfo implements Serializable {
    private Long id;
    private String name;
    private String desc;
}

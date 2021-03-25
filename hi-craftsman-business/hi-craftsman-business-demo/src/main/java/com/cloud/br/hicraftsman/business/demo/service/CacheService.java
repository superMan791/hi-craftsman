package com.cloud.br.hicraftsman.business.demo.service;

import com.cloud.br.hicraftsman.business.demo.domain.entity.BscDictInfo;

import java.util.List;

public interface CacheService {
    List queryTree();

    BscDictInfo insertDict(BscDictInfo obj);

    Boolean deleteById(Long id);

    BscDictInfo queryById(Long id);

    BscDictInfo updateById(BscDictInfo obj, Long id);
}

package com.cloud.br.hicraftsman.business.demo.service.impl;

import com.cloud.br.hicraftsman.business.demo.domain.entity.BscDictInfo;
import com.cloud.br.hicraftsman.business.demo.service.CacheService;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@CacheConfig(cacheNames = "bscDictInfo")
@Service
public class CacheServiceImpl implements CacheService {


    /**
     * 查询的时候,将所有的字典缓存到key=queryTree的redis中
     * @return
     */
    @Override
    @Cacheable( key = "'queryTree'")
    public List queryTree() {
        var list=new ArrayList<>();
        list.add(new BscDictInfo(1L, "tom", "xxx"));
        list.add(new BscDictInfo(2L, "any", "yyyy"));
        return list;
    }

    /**
     * 修改的时候, 更新id=id的缓存项, 并且使缓存列表失效
     * @param obj
     * @param id
     * @return
     */
    @Override
    @CacheEvict(key = "'queryTree'")
    @CachePut(key = "#id")
    public BscDictInfo updateById(BscDictInfo obj, Long id) {
        return obj;
    }

    /**
     * 新增的时候,使缓存列表失效
     * @param obj
     * @return
     */
    @Override
    @CacheEvict( key = "'queryTree'")
    public BscDictInfo insertDict(BscDictInfo obj) {
        return obj;
    }

    /**
     * 删除的时候,id=id的字典项失效, 请求字典列表失效
     * @param id
     * @return
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'queryTree'"),
            @CacheEvict(key = "#id")
    })
    public Boolean deleteById(Long id) {
        return null;
    }

    /**
     * 查询的时候,缓存id=id的字典项
     * @param id
     * @return
     */
    @Override
    @Cacheable(key = "#id")
    public BscDictInfo queryById(Long id) {
        return new BscDictInfo(id,"xxx","23423");
    }
}

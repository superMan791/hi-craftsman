package com.cloud.br.hicraftsman.business.demo.controller;

import com.cloud.br.hicraftsman.common.core.base.R;
import com.cloud.br.hicraftsman.common.core.util.idgenerator.IdWorker;
import com.cloud.br.hicraftsman.business.demo.domain.entity.BscDictInfo;
import com.cloud.br.hicraftsman.business.demo.service.CacheService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 缓存
 */
@RestController
@RequestMapping("cache")
public class CacheController {
    @Resource
    private CacheService cacheService;

    @GetMapping("queryDictTree")
    public R<List<BscDictInfo>> queryTree() {
        return R.ok(cacheService.queryTree());
    }

    @PutMapping("updateDictById/{id}")
    public R<BscDictInfo> updateDictById(@RequestBody BscDictInfo obj, @PathVariable("id") Long id) {
        obj.setId(id);
        return R.ok(cacheService.updateById(obj, id));
    }

    @PostMapping("insertDict")
    public R<BscDictInfo> insertDict(@RequestBody BscDictInfo obj) {
        obj.setId(IdWorker.getId());
        return R.ok(cacheService.insertDict(obj));
    }

    @GetMapping("deleteDictById/{id}")
    public R<Boolean> deleteDictById(@PathVariable Long id) {
        return R.ok(cacheService.deleteById(id));
    }

    @GetMapping("queryById/{id}")
    public R<BscDictInfo> queryById(@PathVariable Long id) {
        return R.ok(cacheService.queryById(id));
    }
}

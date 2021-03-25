package com.cloud.br.hicraftsman.business.demo.controller;

import com.cloud.br.hicraftsman.common.core.base.R;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 */
@RestController
@RequestMapping("lock")
public class LockController {
    @Resource
    private RedissonClient redissonClient;

    @PostMapping("lock/{id}")
    public R lock(@PathVariable Long id) {
        RLock lock = redissonClient.getLock(id.toString());
        //加锁, 5秒后自动释放锁
        lock.lock(5, TimeUnit.SECONDS);
        System.out.println("执行线程不安全的业务操作");
        //主动释放锁
        lock.unlock();
        ;
        return R.ok();
    }

}

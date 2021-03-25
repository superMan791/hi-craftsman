package com.cloud.br.hicraftsman.business.demo.client.feign;

import com.cloud.br.hicraftsman.common.core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("demo-prj")
public interface LockFeign {
    @PostMapping("lock/{id}")
    R lock(@PathVariable Long id);
}

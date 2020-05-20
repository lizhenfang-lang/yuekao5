package com.lizhenfang.yuekao.config;


import com.lizhenfang.yuekao.entity.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "log-server")
public interface FeignConfig {
    @RequestMapping("log/save")
    Log save(@RequestBody Log log);
}

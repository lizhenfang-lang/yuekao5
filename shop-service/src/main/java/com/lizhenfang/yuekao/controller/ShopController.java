package com.lizhenfang.yuekao.controller;

import com.lizhenfang.yuekao.config.FeignConfig;
import com.lizhenfang.yuekao.entity.Log;
import com.lizhenfang.yuekao.dao.NationDao;
import com.lizhenfang.yuekao.dao.ShopDao;
import com.lizhenfang.yuekao.entity.Nation;
import com.lizhenfang.yuekao.entity.Shop;
import com.lizhenfang.yuekao.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private NationDao nationDao;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    FeignConfig feignConfig;

    @Autowired
    private RedisTemplate redisTemplate;

    //列表
    @RequestMapping("/listVo")
    private Page listVo(@RequestParam(defaultValue = "1") Integer current,
                        @RequestParam(defaultValue = "3") Integer size,
                        Shop shop){
        Page<Shop> page= shopService.getPage(current-1,size,shop);

        //向redis中添加操作日志
        redisTemplate.opsForValue().set(UUID.randomUUID().toString(),page.getContent());

        return page;
    }

    //查询地区
    @RequestMapping("/nationlist")
    public List<Nation> nationList(Integer parent){
        return nationDao.findByparent(0);
    }

    @PostMapping("/insert")
    public Object insert(@RequestBody Shop shop){
        shop.setCreatetime(new Date());
        shop.setIsshang("0");
        Shop save= shopDao.save(shop);

        //向redis中添加操作日志
        redisTemplate.opsForValue().set(UUID.randomUUID().toString(),save);

        return save;
    }

    @PostMapping("/update")
    public Object update(@RequestBody Shop shop){
        shop.setCreatetime(new Date());

        Shop save= shopDao.save(shop);
        //向redis中添加操作日志
        redisTemplate.opsForValue().set(UUID.randomUUID().toString(),save);
        return save;
    }

    @RequestMapping("dell")
    public boolean del(Integer [] sid){
        for (int i = 0; i<sid.length  ; i++) {
            //调用日志
           Shop save= shopDao.findShopById(sid[i]);
            Log log=new Log();
            log.setId(UUID.randomUUID().toString());
            log.setName(save.getName());
            log.setType("删除");
            log.setCreatetime(new Date());
            feignConfig.save(log);
            shopDao.deleteById(sid[i]);
        }
        return  true;
    }


}

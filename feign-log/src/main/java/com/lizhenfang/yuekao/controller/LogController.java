package com.lizhenfang.yuekao.controller;

import com.lizhenfang.yuekao.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log")
public class LogController {
    @Autowired
   MongoTemplate mongoTemplate;

    @RequestMapping("save")
    public Log save(@RequestBody Log log){
        return mongoTemplate.save(log);
    }

}

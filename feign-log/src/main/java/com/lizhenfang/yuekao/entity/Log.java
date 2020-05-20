package com.lizhenfang.yuekao.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Log {
    @Id
    private String id;
    private Date createtime;
    private String type;
    private String name;

}

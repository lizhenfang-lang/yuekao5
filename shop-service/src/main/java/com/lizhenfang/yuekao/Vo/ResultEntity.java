package com.lizhenfang.yuekao.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultEntity implements Serializable {
    private static final long serialVersionUID=1L;

    //返回的状态码
    private  Integer code;
    //返回状态码对应文本信息
    private  String msg;
    //返回的数据
    private  Object data;

     public ResultEntity(Integer code, String msg, Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
     }

     //ok的静态方法统一返回的数据格式
    public static ResultEntity ok(Object data){
        return new ResultEntity(1001,"ok",data);
    }

    public static ResultEntity error(Object data){
        return new ResultEntity(4001,"error",data);
    }

}

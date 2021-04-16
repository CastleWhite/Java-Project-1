package com.dagongren.seckill.vo;
// 公共返回对象

import com.baomidou.mybatisplus.extension.api.R;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), null);
    }

    public static RespBean sucess(Object obj){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), obj);
    }

    public static RespBean error(RespBeanEnum respBeanEnum){
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }

    public static RespBean error(RespBeanEnum respBeanEnum, Object obj){
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), obj);
    }
}

package com.xing.democlone.demoexception.constant;


import lombok.Getter;

@Getter
public enum Status {

    OK(200,"操作成功"),

    UNKNOWN_ERROR(500,"服务端出错");


    private Integer code;
    /**
     * 内容
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

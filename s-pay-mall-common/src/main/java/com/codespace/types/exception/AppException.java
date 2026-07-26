package com.codespace.types.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AppException extends RuntimeException{
    //异常码
    private  String code;
    //异常信息
    private String msg;
    public AppException(String code){
        this.code = code;
    }
    public AppException(String code, Throwable cause){
        this.code = code;
        super.initCause(cause);
    }
    public AppException(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public AppException(String code, String message, Throwable cause) {
        this.code = code;
        this.msg = message;
        super.initCause(cause);
    }

    @Override
    public String toString() {
        return "cn.bugstack.x.api.types.exception.XApiException{" +
                "code='" + code + '\'' +
                ", info='" + msg + '\'' +
                '}';
    }




}

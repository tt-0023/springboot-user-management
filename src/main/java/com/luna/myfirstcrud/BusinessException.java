package com.luna.myfirstcrud;

public class BusinessException extends RuntimeException{
    private Integer code;

    public BusinessException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }
    public BusinessException(String msg) {
        super(msg);
    }

    public Integer getCode() {
        return code;
    }

}

package com.example.demo.handle;

/**
 * @author ZL
 * @date 2018/6/12 21:20
 */
public class GirlException extends RuntimeException {
    private Integer code;
    private String msg;


    public GirlException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

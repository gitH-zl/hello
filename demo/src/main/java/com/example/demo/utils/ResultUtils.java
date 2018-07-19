package com.example.demo.utils;

import com.example.demo.domain.Result;

/**
 * @author ZL
 * @date 2018/6/12 21:24
 */
public class ResultUtils {

    public static Result success(Object o) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(o);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

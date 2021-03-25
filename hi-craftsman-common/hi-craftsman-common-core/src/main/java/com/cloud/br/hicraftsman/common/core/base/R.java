package com.cloud.br.hicraftsman.common.core.base;


import com.cloud.br.hicraftsman.common.core.constant.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 返回值封装
 *
 * @author yzp
 * @date 2020/4/13 0013 8:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> ok() {
        return restResult(null, CommonConstants.SUCCESS.getCode(), CommonConstants.SUCCESS.getMessage());
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, CommonConstants.SUCCESS.getCode(), CommonConstants.SUCCESS.getMessage());
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, CommonConstants.SUCCESS.getCode(), msg);
    }

    public static <T> R<T> fail() {
        return restResult(null, CommonConstants.FAIL.getCode(), CommonConstants.FAIL.getMessage());
    }

    public static <T> R<T> fail(String msg) {
        return restResult(null, CommonConstants.FAIL.getCode(), msg);
    }

    public static <T> R<T> fail(T data) {
        return restResult(data, CommonConstants.FAIL.getCode(), CommonConstants.FAIL.getMessage());
    }
    public static <T> R<T> fail(Integer code, String message) {
        return restResult(null, code, message);
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
package com.cloud.br.hicraftsman.common.core.constant;

/**
 * TODO 公共枚举类
 *
 * @author yzp
 * @date 2020/4/13 0013 8:34
 */
public enum CommonConstants {
    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败"),
    AREGUMENT_ERRO(400, "参数绑定异常"),
    AUTHORIZATION_ERROR(401, "鉴权失败"),
    DATA_NOT_EXISTS_ERROR(500001, "数据不存在"),
    DATA_FORMAT_ERROR(500002, "参数格式异常"),
    REQUEST_OTHER_APP_ERROR(500003, "调用服务失败");
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    CommonConstants(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

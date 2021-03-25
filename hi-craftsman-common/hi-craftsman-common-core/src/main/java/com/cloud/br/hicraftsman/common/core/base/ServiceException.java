package com.cloud.br.hicraftsman.common.core.base;

import lombok.Data;

/**
 * 业务异常
 *
 * @author yzp
 * @date 2020/8/2 7:15
 */
@Data
public class ServiceException extends RuntimeException {
    private Integer code;
    public ServiceException() {
        super();
    }
    public ServiceException(Integer code,String message) {
        super(message);
        this.code=code;
    }
    public ServiceException(String message) {
        super(message);
    }

    /**
     * 自定义业务异常，关闭堆栈跟踪
     *
     * @return java.lang.Throwable
     * @author yzp
     * @date 2020/8/2 7:37
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }
}

package com.cloud.br.hicraftsman.common.core.handler;

import com.cloud.br.hicraftsman.common.core.base.R;
import com.cloud.br.hicraftsman.common.core.base.ServiceException;
import com.cloud.br.hicraftsman.common.core.constant.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * TODO 全局异常捕获类
 *
 * @author yzp
 * @date 2020/4/13 0013 8:34
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常捕获
     *
     * @param e
     * @return com.dragon.cloud.common.base.R
     * @author yzp
     * @date 2020/8/2 7:35
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exception(Exception e) {
        e.printStackTrace();
        return R.fail();
    }

    /**
     * 参数校验失败
     *
     * @param e
     * @return com.dragon.cloud.common.base.R
     * @author yzp
     * @date 2020/8/2 7:35
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        //获取异常中随机一个异常信息
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return R.fail(CommonConstants.DATA_FORMAT_ERROR.getCode(),defaultMessage);
    }

    /**
     * 参数绑定失败
     *
     * @param e
     * @return com.dragon.cloud.common.base.R
     * @author yzp
     * @date 2020/8/2 7:34
     */
    @ExceptionHandler(BindException.class)
    public R bindExceptionHandler(BindException e) {
        //获取异常中随机一个异常信息
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return R.fail(CommonConstants.AREGUMENT_ERRO.getCode(),defaultMessage);
    }

    /**
     * 参数校验失败
     *
     * @param e
     * @return com.dragon.cloud.common.base.R
     * @author yzp
     * @date 2020/8/2 7:34
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public R constraintViolationExceptionHandler(ConstraintViolationException e) {
        //获取异常中第一个错误信息
        String message = e.getConstraintViolations().iterator().next().getMessage();
        return R.fail(CommonConstants.DATA_FORMAT_ERROR.getCode(),message);
    }

    /**
     * 处理自定义异常，取message信息返回给前端
     *
     * @param e
     * @return com.dragon.cloud.common.base.R
     * @author yzp
     * @date 2020/8/2 7:33
     */
    @ExceptionHandler(ServiceException.class)
    public R bExceptionHandler(ServiceException e) {
        return R.fail(e.getCode(),e.getMessage());
    }

}
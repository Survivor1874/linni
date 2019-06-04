package com.learn.linni.exception;

import com.learn.linni.common.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获
 **/
@ControllerAdvice
@Slf4j
public class OverallAdvice {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JsonResult errorHandler(Exception ex) {
        log.error(ex.getMessage());
        JsonResult result = new JsonResult(500,ex.getMessage());
        log.error(ex.getMessage(),ex);
        return result;
    }
}

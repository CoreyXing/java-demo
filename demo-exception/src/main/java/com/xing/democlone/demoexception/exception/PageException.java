package com.xing.democlone.demoexception.exception;

import com.xing.democlone.demoexception.constant.Status;
import lombok.Getter;


@Getter
public class PageException extends BaseException{
    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}

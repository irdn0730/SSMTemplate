package com.wn32.exception;

/**
 * 自定义异常：
 *      自定义异常不是用于解决语法问题，而是用于解决业务逻辑中的问题
 *
 */
public class Wn32Exception extends Exception{
    public Wn32Exception() {
        super();
    }

    public Wn32Exception(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "这是我们自定义异常！";
    }
}

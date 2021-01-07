package com.wn32.resolver;

import com.wn32.exception.Wn32Exception;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Wn32ExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        Wn32Exception we = null;

        if (ex instanceof Wn32Exception)
            we = (Wn32Exception) ex;
        else
            we = new Wn32Exception("【系统错误,请与管理员联系】");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",we.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

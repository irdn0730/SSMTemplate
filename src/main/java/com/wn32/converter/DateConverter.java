package com.wn32.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        System.out.println("日期类型转换器！！！");
        DateFormat format = null;
        try {
            if (StringUtils.isEmpty(source))
                throw new IllegalArgumentException("原始日期不可以为空");
            //-- select * from student wher stuId = ?;
            format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(source);
            return date;
        } catch (ParseException e) {
            throw new NullPointerException(e.getMessage());
        }
    }
}

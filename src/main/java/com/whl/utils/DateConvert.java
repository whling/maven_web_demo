package com.whl.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Whling
 * @Date: Created in 18:58 2017/1/2
 * @Modified By:
 * @Description:
 */
public class DateConvert implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            //ParsePosition pos = new ParsePosition(8);
            date = simpleDateFormat.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}

package com.whl.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Author: Whling
 * @Date: Created in 15:16 2017/10/8
 * @Modified By:
 * @Description:
 */
public class GlobalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        HashMap<String, Object> map = new HashMap<>();
        map.put("error", "system occur error!");
        view.setAttributesMap(map);
        modelAndView.setView(view);
        return modelAndView;
    }
}

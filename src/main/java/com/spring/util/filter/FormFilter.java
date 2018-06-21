package com.spring.util.filter;

import com.spring.util.form.FormResult;
import com.spring.util.form.FormSelector;
import com.spring.util.form.MyForm;

import java.io.IOException;

import javax.servlet.*;

/**
 * @name FormFilter
 * @description 表单验证过滤器
 * @auther ten
 */
public class FormFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @name doFilter
     * @description 验证表单过滤器
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /* 提取请求信息 */
//        String action_type= (String) servletRequest.getAttribute("action");
        String action_type=servletRequest.getParameter("action");

        System.out.println("formfilter 请求信息为:"+action_type);

        if (action_type!=null) {
            /* 转发到Form,获取对应Form对象 */
            MyForm form = FormSelector.select(action_type);

            /* 获取Form验证的结果集 */
            FormResult result = form.validate(servletRequest);

            /* 设置result到req */
            servletRequest.setAttribute("result", result);
        }

        if (filterChain==null){
            System.out.println("formfilter chain null 异常");
        }else{
             /* 转发req到servlet */
        filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    public void destroy() {

    }
}

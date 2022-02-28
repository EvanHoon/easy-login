package com.rwh.sanxingdui.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @className: com.rwh.sanxingdui.interceptor.LoginHandlerInterceptor
 * @author: Wenhao.Ren
 * @create: 2021/12/15 17:13
 */
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("token");
        if (user != null) {
            // 放行
            return true;
        }
        //拦截住。未登录
//        log.info("未登录,重定向到登录页");
//        request.getRequestDispatcher("/login").forward(request, response); // 转发
//        response.sendRedirect("/login"); // 重定向
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}

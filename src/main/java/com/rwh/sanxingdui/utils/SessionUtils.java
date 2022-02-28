package com.rwh.sanxingdui.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @className: com.rwh.sanxingdui.utils.ServletUtil
 * @author: Wenhao.Ren
 * @create: 2021/12/15 17:08
 */
public class SessionUtils {

    public static HttpSession getHttpSession() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

}



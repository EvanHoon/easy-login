package com.rwh.sanxingdui.utils;

import java.util.Date;

public class MessageUtil {
    /**
     * 服务器错误
     */
    public static Message error(String msg) {
        Message message = new Message();
        message.setStatus("error");
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 失败
     */
    public static Message redict(String msg) {
        Message message = new Message();
        message.setStatus("redict");
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 成功
     */
    public static Message success(String msg) {
        Message message = new Message();
        message.setStatus("ok");
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 成功  返回数据
     */
    public static Message success(String msg, Object data) {
        Message message = new Message();
        message.setStatus("ok");
        message.setMessage(msg);
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 返回成功的消息，一般用于查询操作的结果返回
     */
    public static Message success(Object data) {
        Message message = new Message();
        message.setStatus("ok");
        message.setMessage("success");
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }

//    /**
//     * @Description: 权限不足
//     * @Param: []
//     * @return: com.jacky.base.utils.Message
//     * @Author: charles
//     * @Date: 2019-11-19
//     */
//    public static Message forbidden(String msg) {
//        Message message = new Message();
//        message.setStatus(403);
//        message.setMessage(msg);
//        message.setTimestamp(new Date().getTime());
//        return message;
//    }

//    /**
//     * @Description: 未授权
//     * @Param: []
//     * @return: com.jacky.base.utils.Message
//     * @Author: charles
//     * @Date: 2019-11-19
//     */
//    public static Message unAuthorized(String msg) {
//        Message message = new Message();
//        message.setStatus(401);
//        message.setMessage(msg);
//        message.setTimestamp(new Date().getTime());
//        return message;
//    }


}

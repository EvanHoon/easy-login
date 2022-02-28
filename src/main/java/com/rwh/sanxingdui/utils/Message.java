package com.rwh.sanxingdui.utils;

import lombok.Data;

@Data
public class Message {
    private String status; //状态码 成功:ok  服务器错误:error  失败:redict
    private String message; //信息
    private Object data;    //返回数据
    private Long timestamp; //时间戳
}

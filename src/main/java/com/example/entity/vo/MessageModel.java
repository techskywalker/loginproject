package com.example.entity.vo;

import lombok.Data;

@Data

public class MessageModel {

    private Integer code = 1;
    private String msg = "成功！";
    private Object object;

}

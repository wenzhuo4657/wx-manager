package org.wenzhuo4657.wx.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/16
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBehaviorMessageDto {

    private String openId;
    private String fromUserName;
    private String msgType;
    private String content;
    private String event;
    private Date createTime;

}

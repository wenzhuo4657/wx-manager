package org.wenzhuo4657.wx.api;


import org.wenzhuo4657.wx.api.dto.UserBehaviorMessageDto;

/**
 * @className: IWeiXinBehaviorService
 * @author: wenzhuo4657
 * @date: 2024/9/8 15:29
 * @Version: 1.0
 * @description: weixin公众号受理用户行为
 */
public interface IWeiXinBehaviorService {


    String acceptUserBehavior(UserBehaviorMessageDto userBehaviorMessageEntity);
}
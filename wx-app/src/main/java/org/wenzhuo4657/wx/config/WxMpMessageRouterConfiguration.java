package org.wenzhuo4657.wx.config;

import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/17
 * @description: 消息路由处理
 */
@RequiredArgsConstructor
@Configuration
public class WxMpMessageRouterConfiguration {
    @Resource
    private final WxMpMessageHandler msgHandler;

    @Bean
    public WxMpMessageRouter messageRouter(WxMpService wxMpService){
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxMpService);
        newRouter.rule().async(false).handler( this.msgHandler).end();
        return  newRouter;
    }
}

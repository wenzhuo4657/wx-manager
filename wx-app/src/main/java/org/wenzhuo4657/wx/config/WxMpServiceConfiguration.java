package org.wenzhuo4657.wx.config;

import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.BaseWxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceOkHttpImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class WxMpServiceConfiguration {

    @Bean
    public WxMpService wxMpService() {

        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId("wx501a1603b0e3c03d"); // 设置微信公众号的appid
        config.setSecret("78ec62f38f47c552283ed449d4574c2a"); // 设置微信公众号的app corpSecret
        config.setToken("theRegion"); // 设置微信公众号的token
        config.setAesKey("OXEWWrleUSttcVnzfId75eP3ysPeL6p47YDeOJrSkfG"); // 设置微信公众号的EncodingAESKey
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setMaxRetryTimes(3);
        wxMpService.setWxMpConfigStorage(config);
        return wxMpService;
    }


}

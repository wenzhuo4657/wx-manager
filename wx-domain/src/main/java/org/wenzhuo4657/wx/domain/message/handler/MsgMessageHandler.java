package org.wenzhuo4657.wx.domain.message.handler;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.util.WxMpConfigStorageHolder;
import org.springframework.stereotype.Component;
import org.wenzhuo4657.wx.domain.message.autoReply.MsgReplyService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/17
 * @description:
 */
@Slf4j
@Component
public class MsgMessageHandler implements WxMpMessageHandler {
    @Resource
    private MsgReplyService msgReplyService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) {
        String textContent = wxMessage.getContent();
        String fromUser = wxMessage.getFromUser();
        String msgType = wxMessage.getMsgType();
        String appid = WxMpConfigStorageHolder.get();

        try {
            return msgReplyService.reply(fromUser, msgType, textContent, appid);

        } catch (WxErrorException e) {
            log.error("处理消息错误，{}",e);
        }
        return  null;

    }
}

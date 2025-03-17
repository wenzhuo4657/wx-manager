package org.wenzhuo4657.wx.domain.message.autoReply;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.service.WxService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;
import org.wenzhuo4657.wx.domain.message.autoReply.MsgReplyService;

import javax.annotation.Resource;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/17
 * @description: 默认实现
 */
@Component
public class DefaultMsgReplyServiceImpl  implements MsgReplyService {

    @Resource
    private WxMpService wxMpService;





    @Override
    public void defaultReply(String toUser, String replyContent) {

    }

    @Override
    public WxMpXmlOutMessage replyText(String toUser, String replyContent) throws WxErrorException {
        String content=DefaultReple.text;


//        文本回复分为两种，1，指令回复，2，大模型回复，
        return  WxMpXmlOutMessage.TEXT()
                .toUser(toUser)
                .fromUser("gh_ce466ae81f85")
                .content(content).build();
    }

    @Override
    public void replyImage(String toUser, String mediaId) throws WxErrorException {

    }

    @Override
    public void replyVoice(String toUser, String mediaId) throws WxErrorException {

    }
}

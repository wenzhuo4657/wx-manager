package org.wenzhuo4657.wx.domain.message.autoReply;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.service.WxService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.annotation.Resource;


public  interface MsgReplyService {





    default WxMpXmlOutMessage reply(String toUser, String replyType, String replyContent, String appid) throws WxErrorException {
            if (WxConsts.KefuMsgType.TEXT.equals(replyType)) {
               return this.replyText(toUser, replyContent);
            }
//            else if (WxConsts.KefuMsgType.IMAGE.equals(replyType)) {
//                this.replyImage(toUser, replyContent);
//            } else if (WxConsts.KefuMsgType.VOICE.equals(replyType)) {
//                this.replyVoice(toUser, replyContent);
//            }else {
//                this.defaultReply(toUser,replyContent);
//            }
        return  null;

    }

    /**
     *  @author:wenzhuo4657
        des: 默认回复处理。
    */
    void defaultReply(String toUser, String replyContent);

    /**
     * 回复文字消息
     */
    WxMpXmlOutMessage replyText(String toUser, String replyContent) throws WxErrorException;

    /**
     * 回复图片消息
     */
    void replyImage(String toUser, String mediaId) throws WxErrorException;

    /**
     * 回复录音消息
     */
    void replyVoice(String toUser, String mediaId) throws WxErrorException;




    static  class DefaultReple{
        public static  final  String text="说的什么玩意，无法理解~~~~~";

    }


}

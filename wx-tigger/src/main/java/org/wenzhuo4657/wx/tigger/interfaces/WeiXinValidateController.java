package org.wenzhuo4657.wx.tigger.interfaces;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.wenzhuo4657.wx.domain.auth.service.IWeiXinValidateService;


import javax.annotation.Resource;

/**
 * @className: WeiXinPortalController
 * @author: wenzhuo4657
 * @date: 2024/5/21 18:26
 * @Version: 1.0
 * @description: 微信公众号相关处理
 */

@RestController
@RequestMapping("/wx/portal/{appid}")
public class WeiXinValidateController {

    private final Logger logger = LoggerFactory.getLogger(WeiXinValidateController.class);


    @Value("${wx.config.originalid}")
    private String originalId;


    @Resource
    private IWeiXinValidateService weiXinValidateService;



    /**
     * 微信服务器配置验证:微信服务器会发送get请求，进行签名的验证，
     * 如果验证成功则返回echostr,则接入生效，服务器配置生效，否则接入服务器失败，
     * 成功后可根据接口文档进行其他配置<p>
     * * appid     微信端AppID<br>
     * * signature 微信端发来的签名<br>
     * * timestamp 微信端发来的时间戳<br>
     * * nonce     微信端发来的随机字符串<br>
     * * echostr   微信端发来的验证字符串<br>
     */
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String validate(
            @PathVariable String appid,
            @RequestParam(value = "signature", required = false) String signature,
            @RequestParam(value = "timestamp", required = false) String timestamp,
            @RequestParam(value = "nonce", required = false) String nonce,
            @RequestParam(value = "echostr", required = false) String echostr
    ) {
        try {
            logger.info("微信公众号验签信息{}开始 [{}, {}, {}, {}]", appid, signature, timestamp, nonce, echostr);

            if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
                throw new IllegalArgumentException("请求参数非法，请核实!");
            }
            boolean check = weiXinValidateService.checkSign(signature, timestamp, nonce);
            logger.info("微信公众号验签信息{}完成 check：{}", appid, check);

            if (!check) {
                return null;
            }

            return echostr;
        } catch (Exception e) {
            logger.error("微信公众号验签信息{}失败 [{}, {}, {}, {}]", appid, signature, timestamp, nonce, echostr, e);
            return null;
        }
    }



}
package org.wenzhuo4657.wx.domain.auth.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.wenzhuo4657.wx.common.util.SignatureUtil;
import org.wenzhuo4657.wx.domain.auth.service.IWeiXinValidateService;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/16
 * @description:
 */
@Service
public class WeiXinValidateService implements IWeiXinValidateService {
    @Value("${wx.config.token}")
    private String token;
    @Override
    public boolean checkSign(String signature, String timestamp, String nonce) {
        return SignatureUtil.check(token, signature, timestamp, nonce);
    }
}

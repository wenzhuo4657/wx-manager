package org.wenzhuo4657.wx.domain.auth.service;

public interface IWeiXinValidateService {


    /**
     *  des: 验证签名：
     * */
    boolean checkSign(String signature, String timestamp, String nonce);


}

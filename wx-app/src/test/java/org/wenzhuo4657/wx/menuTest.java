package org.wenzhuo4657.wx;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/16
 * @description:
 */
@SpringBootTest
public class menuTest {
    @Autowired
    private WxMpService wxMpService;

    /**
     *  @author:wenzhuo4657
        des:  自定义菜单测试，（暂无权限）
    */

    @Test
    public void addMenu() throws WxErrorException {
        WxMenu wxMenu = new WxMenu();
        WxMenuButton wxMenuButton = new WxMenuButton();
        wxMenuButton.setType("click");
        wxMenuButton.setName("blog");
        wxMenuButton.setUrl("https://wenzhuo4657.org/");
        ArrayList<WxMenuButton> wxMenuButtons = new ArrayList<>();
        wxMenuButtons.add(wxMenuButton);
        wxMenu.setButtons(wxMenuButtons);
        wxMpService.getMenuService().menuCreate(wxMenu);

    }
}

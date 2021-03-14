package com.example.wps.wps_invite.controller;

import com.example.wps.wps_invite.entity.ResultSet;
import com.example.wps.wps_invite.service.WpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WpsController {

    private WpsService wpsService;

    @Autowired
    public WpsController(WpsService wpsService) {
        this.wpsService = wpsService;
    }

    /**
     * 显示主界面
     *
     * @return wps_invite.html
     */

    @RequestMapping("/")
    public String index() {
        return "redirect:/wps";
    }

    /**
     * 显示wps界面
     *
     * @return wps_invite.html
     */

    @RequestMapping("/wps")
    public String wps() {
        return "wps_invite";
    }

    /**
     * 自动邀请
     *
     * @param uid 当前用户uid
     * @return 是否成功
     */

    @RequestMapping("/wpsAutoInviteByAjax")
    @ResponseBody
    public ResultSet wpsAutoInviteByAjax(@RequestParam(value = "uid", required = false) String uid) {
        return wpsService.wpsAutoInvite(uid);
    }
}

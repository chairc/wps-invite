package com.example.wps.wps_invite.controller;

import com.example.wps.wps_invite.entity.ResultSet;
import com.example.wps.wps_invite.service.ClientCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther chairc
 * @date 2021/5/1 21:30
 */
@Controller
public class ClientCodeController {

    private ClientCodeService clientCodeService;

    @Autowired
    public ClientCodeController(ClientCodeService clientCodeService) {
        this.clientCodeService = clientCodeService;
    }

    /**
     * 新增client_code与client参数接口（可用抓包软件接口）
     *
     * @param clientCode 客户端码
     * @param client     客户端类型
     * @return 是否成功
     */

    @RequestMapping("/insertClientCode")
    @ResponseBody
    public ResultSet insertClientCode(@RequestParam(value = "clientCode", required = false) String clientCode,
                                      @RequestParam(value = "client", required = false) String client) {
        return clientCodeService.insertClientCode(clientCode, client);
    }
}

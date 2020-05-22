package com.example.wps.wps_invite.controller;

import com.example.wps.wps_invite.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EntertainmentController {
    @Autowired
    private EntertainmentService entertainmentService;

    @RequestMapping("/wps")
    public String wpsLogin(){
        return "wps_invite";
    }

    @RequestMapping("/wpsAutoInviteByAjax")
    @ResponseBody
    public Object wpsAutoInviteByAjax(@RequestParam(value = "uid", required = false) String uid){
        Map<String,String> map = new HashMap<>();
        String i = entertainmentService.wpsAutoInvite(uid);
        assert i != null;
        if(i.equals("1")){
            map.put("result","1");
        }else {
            map.put("result","0");
        }
        return map;
    }
}
